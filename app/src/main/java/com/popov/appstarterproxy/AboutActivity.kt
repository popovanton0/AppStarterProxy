/*
 * Copyright 2018 Anton Popov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *         You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.popov.appstarterproxy

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.danielstone.materialaboutlibrary.MaterialAboutActivity
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard
import com.danielstone.materialaboutlibrary.model.MaterialAboutList


class AboutActivity : MaterialAboutActivity() {
    override fun getMaterialAboutList(context: Context): MaterialAboutList {
        return MaterialAboutList.Builder()
                .addCard(MaterialAboutCard.Builder()
                        .addItem(MaterialAboutTitleItem.Builder()
                                .text(R.string.app_name)
                                .desc(R.string.description)
                                .icon(R.mipmap.ic_launcher_round)
                                .build())
                        .addItem(MaterialAboutActionItem.Builder()
                                .text(R.string.version_text)
                                .subText(packageManager.getPackageInfo(packageName, 0).versionName)
                                .icon(R.drawable.ic_info_outline_grey_24dp)
                                .build())
                        .build())
                .addCard(MaterialAboutCard.Builder()
                        .title(R.string.author_title)
                        .addItem(MaterialAboutActionItem.Builder()
                                .text(R.string.author_name)
                                .subText(R.string.author_profession)
                                .icon(R.drawable.ic_person_grey_24dp)
                                .build()
                        )
                        .addItem(MaterialAboutActionItem.Builder()
                                .text(R.string.github)
                                .icon(R.drawable.ic_github_circle_grey_24dp)
                                .setOnClickAction {
                                    startActivity(Intent(Intent.ACTION_VIEW,
                                            Uri.parse(getString(R.string.author_on_github_url)))
                                    )
                                }
                                .build())
                        .build())
                .addCard(MaterialAboutCard.Builder()
                        .title(R.string.licenses)
                        .addItem(MaterialAboutActionItem.Builder()
                                .text(R.string.app_icon)
                                .subTextHtml(getString(R.string.app_icon_license))
                                .icon(R.drawable.ic_launcher_foreground)
                                .build()
                        )
                        .build())
                .build()
    }

    override fun getActivityTitle(): CharSequence {
        return getString(R.string.about_menu_item_title)
    }
}
