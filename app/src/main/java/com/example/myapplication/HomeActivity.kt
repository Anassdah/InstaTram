package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.main.HomeViewModel
import com.example.myapplication.ui.main.MainFragment
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.main_fragment.*

class HomeActivity : AppCompatActivity() {
    public val tramNames = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf : MenuInflater = menuInflater
        inf.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId
        if (id==R.id.menu_home){
            Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,HActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.menu_map){
            Toast.makeText(this,"Map", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_language){
            Toast.makeText(this,"Language", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_theme){
            Toast.makeText(this,"Theme", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}