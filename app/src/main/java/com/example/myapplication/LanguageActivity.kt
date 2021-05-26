package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_language.*
import java.util.*

class LanguageActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    View.OnTouchListener {
    private lateinit var languageList: ArrayList<Language>
    private var isTouched: Boolean = false
    private val TAG = "LanguageActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        languageList = arrayListOf(
            Language(R.drawable.us, "English", "en"),
            Language(R.drawable.es, "Spanish", "es")

        )
        spinner.adapter = SpinnerAdapter(this, languageList)
        val currentLanguage = Locale.getDefault().getLanguage()
        val index: Int = languageList.indexOfFirst { l -> l.code == currentLanguage }
        spinner.setSelection(index)

        spinner.setOnTouchListener(this)
        spinner.onItemSelectedListener = this
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        isTouched = true
        return false
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (!isTouched) return
        val language = languageList[p2]
        Log.v(TAG, "touched=$language , index = $p2")

        changeLanguage(language.code)
        isTouched = false
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    private fun changeLanguage(code: String) {

        val config = resources.configuration
        val locale = Locale(code)

        Locale.setDefault(locale)
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)

        recreate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf: MenuInflater = menuInflater
        inf.inflate(R.menu.main_menu, menu)
        return true
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