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

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.popov.appstarterproxy.model.AndroidApp
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitle(R.string.app_name)
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))
        setSupportActionBar(toolbar)

        val mainIntent2 = Intent(Intent.ACTION_MAIN, null)
        mainIntent2.addCategory(Intent.CATEGORY_LAUNCHER)
        val appsList = packageManager.queryIntentActivities(mainIntent2, 0).map {
            AndroidApp(
                    it.loadLabel(packageManager).toString(),
                    it.activityInfo.packageName/*,
                    it.loadIcon(packageManager)*/
            )
        }

        val arrayAdapter = ArrayAdapter<AndroidApp>(this, android.R.layout.select_dialog_item)
        arrayAdapter.addAll(appsList)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val packageName = arrayAdapter.getItem(position).packageName
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.primaryClip = ClipData.newPlainText("app url", getString(R.string.url) + packageName)
            Toast.makeText(this, R.string.url_copied, LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean = menuInflater.inflate(R.menu.main, menu).run { true }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.about -> {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
