package com.example.myapplication

import android.app.TabActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TabHost
import android.widget.Toast

class MainActivity2 : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tabHost = findViewById<TabHost>(android.R.id.tabhost)
        if (tabHost != null) {
            addTab(tabHost, getString(R.string.Home), getString(R.string.Home), HomeActivity::class.java)
            addTab(tabHost, getString(R.string.Map), getString(R.string.Map), MapActivity::class.java)
            tabHost.currentTab = 1
            tabHost.setOnTabChangedListener { tabId -> Toast.makeText(applicationContext, tabId, Toast.LENGTH_SHORT).show() }
        }
    }

    private fun addTab(tabHost: TabHost, name: String, indicator: String, className: Class<*>) {
        val tabSpec = tabHost.newTabSpec(name)
        tabSpec.setIndicator(indicator)
        val intent = Intent(this, className)
        tabSpec.setContent(intent)
        tabHost.addTab(tabSpec)
    }
}