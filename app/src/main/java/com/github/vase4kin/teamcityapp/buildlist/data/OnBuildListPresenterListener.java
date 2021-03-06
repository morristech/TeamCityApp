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

package com.github.vase4kin.teamcityapp.buildlist.data;

import com.github.vase4kin.teamcityapp.buildlist.api.Build;
import com.mugen.MugenCallbacks;

/**
 * On build item click listener
 */
public interface OnBuildListPresenterListener extends MugenCallbacks {

    /**
     * Handle click event on build item in adapter
     *
     * @param build - Build
     */
    void onBuildClick(Build build);

    /**
     * On run build fab button click
     */
    void onRunBuildFabClick();

    /**
     * Show queued build snack bar
     */
    void onShowQueuedBuildSnackBarClick();

    /**
     * Show favorites
     */
    void onNavigateToFavorites();

    /**
     * On filter builds option menu click
     */
    void onFilterBuildsOptionMenuClick();

    /**
     * On add to favorites build click
     */
    void onAddToFavoritesOptionMenuClick();

    /**
     * On reset filters action click
     */
    void onResetFiltersSnackBarActionClick();
}
