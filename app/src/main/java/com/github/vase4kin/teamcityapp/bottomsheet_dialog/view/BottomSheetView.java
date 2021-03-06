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

package com.github.vase4kin.teamcityapp.bottomsheet_dialog.view;

import com.github.vase4kin.teamcityapp.bottomsheet_dialog.model.BottomSheetDataModel;

/**
 * View for bottom sheet
 */
public interface BottomSheetView {

    /**
     * Init views
     */
    void initViews(OnBottomSheetClickListener listener, BottomSheetDataModel dataModel, String title);

    /**
     * Unbind views
     */
    void unbindViews();

    /**
     * Close bottom sheet
     */
    void close();

    /**
     * Click listener
     */
    interface OnBottomSheetClickListener {
        /**
         * On copy action click
         *
         * @param text - text to copy
         */
        void onCopyActionClick(String text);

        /**
         * On show builds built on this branch click
         *
         * @param branch - branch name
         */
        void onShowBuildsActionClick(String branch);

        /**
         * On show build type click
         */
        void onShowBuildTypeActionClick();

        /**
         * On show project click
         */
        void onShowProjectActionClick();

        /**
         * On artifact download click
         *
         * @param fileName - file name
         * @param href     - href
         */
        void onArtifactDownloadActionClick(String fileName, String href);

        /**
         * On artifact open click
         *
         * @param href - file href
         */
        void onArtifactOpenActionClick(String href);

        /**
         * On artifact open in browser click
         *
         * @param href - file href
         */
        void onArtifactBrowserOpenActionClick(String href);
    }
}
