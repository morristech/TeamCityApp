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

package com.github.vase4kin.teamcityapp.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Guest user interceptor
 * <p>
 * Appending ?guest=1 for each request url
 */
public class GuestUserAuthInterceptor implements Interceptor {

    /**
     * Query name
     */
    private static final String QUERY_PARAM = "guest";
    /**
     * Query value
     */
    private static final String QUERY_VALUE = "1";

    /**
     * {@inheritDoc}
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl urlWithGuestSupport = chain.request().url()
                .newBuilder()
                .addQueryParameter(QUERY_PARAM, QUERY_VALUE).build();
        Request requestWithGuestSupport = chain.request().newBuilder().url(urlWithGuestSupport).build();
        return chain.proceed(requestWithGuestSupport);
    }
}
