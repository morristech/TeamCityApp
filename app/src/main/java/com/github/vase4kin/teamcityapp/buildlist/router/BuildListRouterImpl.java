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

package com.github.vase4kin.teamcityapp.buildlist.router;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.github.vase4kin.teamcityapp.build_details.view.BuildDetailsActivity;
import com.github.vase4kin.teamcityapp.buildlist.api.Build;
import com.github.vase4kin.teamcityapp.favorites.view.FavoritesActivity;
import com.github.vase4kin.teamcityapp.filter_builds.view.FilterBuildsActivity;
import com.github.vase4kin.teamcityapp.runbuild.view.RunBuildActivity;

/**
 * impl of {@link BuildListRouter}
 */
public class BuildListRouterImpl implements BuildListRouter {

    protected Activity mActivity;

    public BuildListRouterImpl(Activity mActivity) {
        this.mActivity = mActivity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void openBuildPage(Build build, @Nullable String buildTypeName) {
        BuildDetailsActivity.start(mActivity, build, buildTypeName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void openRunBuildPage(String buildTypeId) {
        RunBuildActivity.startForResult(mActivity, buildTypeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void openFilterBuildsPage(String buildTypeId) {
        FilterBuildsActivity.startForResult(mActivity, buildTypeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void openFavorites() {
        FavoritesActivity.start(mActivity);
    }
}
