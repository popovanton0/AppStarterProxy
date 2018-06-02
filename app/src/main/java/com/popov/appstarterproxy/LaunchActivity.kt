package com.popov.appstarterproxy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val packageName = intent.data?.host ?: ""
        openApp(this, packageName)
        finish()
    }

    private fun openApp(context: Context, packageName: String): Boolean {
        try {
            val intent = context.packageManager
                    .getLaunchIntentForPackage(packageName) ?: return false
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            context.startActivity(intent)
            return true
        } catch (e: Exception) {
            return false
        }
    }
}
