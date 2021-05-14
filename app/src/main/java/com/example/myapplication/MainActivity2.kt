package com.example.myapplication

import android.app.TabActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf :MenuInflater= menuInflater
        inf.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId
        if (id==R.id.menu_home){
            Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
            val intent:Intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.menu_map){
            Toast.makeText(this,"Map",Toast.LENGTH_SHORT).show()
            val intent:Intent=Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_language){
            Toast.makeText(this,"Language",Toast.LENGTH_SHORT).show()
            val intent:Intent=Intent(this,LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_theme){
            Toast.makeText(this,"Theme",Toast.LENGTH_SHORT).show()
            val intent:Intent=Intent(this,ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}