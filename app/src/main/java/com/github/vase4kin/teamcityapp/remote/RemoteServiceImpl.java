/*
 * Copyright 2016 Andrey Tolpeev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.vase4kin.teamcityapp.remote;

import android.support.annotation.NonNull;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import io.fabric.sdk.android.Fabric;

public class RemoteServiceImpl implements RemoteService {

    private final static long cache = 43200L;

    private final FirebaseRemoteConfig remoteConfig;

    public RemoteServiceImpl(FirebaseRemoteConfig remoteConfig) {
        this.remoteConfig = remoteConfig;
    }

    @Override
    public boolean isNotChurn() {
        fetch();
        return remoteConfig.getBoolean(PARAMETER_NOT_CHURN);
    }

    private void fetch() {
        long cacheExpiration = cache;
        if (remoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration = 0;
        }
        remoteConfig.fetch(cacheExpiration).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    remoteConfig.activateFetched();
                } else {
                    Exception exception = task.getException();
                    if (exception != null && Fabric.isInitialized()) {
                        Crashlytics.logException(task.getException());
                    }
                }
            }
        });
    }
}
