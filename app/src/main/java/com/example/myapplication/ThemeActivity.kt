package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class ThemeActivity : AppCompatActivity() {
    private val TAG = "ThemeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf: MenuInflater = menuInflater
        inf.inflate(R.menu.main_menu, menu)
        val button = findViewById<Button>(R.id.button2);
        var isDarkMode: Boolean? = isDarkTheme(this);
        Log.v(TAG, "isDarkmode=$isDarkMode ")
        if (isDarkMode == false) {
            button.setText(R.string.enable_dark_mode)
        } else {
            button.setText(R.string.disable_dark_mode)
        }
        button.setOnClickListener(View.OnClickListener { view: View? ->
            if (isDarkMode == false) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                isDarkMode = true;
                button.setText(R.string.disable_dark_mode)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                isDarkMode = false;
                button.setText(R.string.enable_dark_mode)

            }
        })

        return true
    }

    fun isDarkTheme(activity: Activity): Boolean {
        return activity.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.menu_home) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, HActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.menu_map) {
            Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.setting_language) {
            Toast.makeText(this, "Language", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.setting_theme) {
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}