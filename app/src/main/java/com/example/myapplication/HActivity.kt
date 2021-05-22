package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_h.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("UNREACHABLE_CODE")
class HActivity : AppCompatActivity() {
    var tram = arrayOfNulls<String>(56)

    var layoutManager: RecyclerView.LayoutManager?=null
    var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h)

        val rf = Retrofit.Builder()
            .baseUrl(StationInter.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        var API = rf.create(StationInter::class.java)
        var call=API.trams

        call?.enqueue(object:Callback<List<Stations?>?>{
            override fun onResponse(
                call: Call<List<Stations?>?>,
                response: retrofit2.Response<List<Stations?>?>
            ) {
                var tramlist:List<Stations>?=response.body() as List<Stations>

                for (i in tramlist!!.indices){
                    tram[i]= tramlist!![i]!!.name

                }
                var tadapter=ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,tram)
                listView.adapter=tadapter
            }

            override fun onFailure(call: Call<List<Stations?>?>, t: Throwable) {
            }

        })
        listView.setOnItemClickListener { parent, view, position, id ->
            val element = adapter?.getItemId(position) // The item that was clicked
            val intent = Intent(this, PictureListActivity::class.java)
            startActivity(intent)
        }

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
            val intent:Intent=Intent(this,HActivity::class.java)
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

