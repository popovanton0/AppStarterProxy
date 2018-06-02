package com.popov.appstarterproxy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitle(R.string.app_name)
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))
        setSupportActionBar(toolbar)
    }
}
