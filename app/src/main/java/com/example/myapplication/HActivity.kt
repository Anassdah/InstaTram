package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_h.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*

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
                var adapter=ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,tram)
                listView.adapter=adapter
            }

            override fun onFailure(call: Call<List<Stations?>?>, t: Throwable) {
            }

        })
        //listView.setOnClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
        //}
        //})
        /*layoutManager= LinearLayoutManager(this)

        recyclerView.layoutManager=layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter=adapter*/
    }
}