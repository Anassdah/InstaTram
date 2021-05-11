package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_h.*
import org.json.JSONArray
import org.json.JSONObject

@Suppress("UNREACHABLE_CODE")
class HActivity : AppCompatActivity() {
    private var mTextViewResult : TextView?=null
    private var mQueue: RequestQueue?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h)

        mTextViewResult = findViewById(R.id.text_view_result)
        val buttonParse :Button=findViewById(R.id.button_parse)

        mQueue = Volley.newRequestQueue(this )

        buttonParse.setOnClickListener(View.OnClickListener { jsonparse() })


    }

    private fun jsonparse() {
        val url : String="https://mocki.io/v1/5a999e8f-8540-47f5-afaa-0ade23c12930"
        val request : JsonObjectRequest= JsonObjectRequest(Request.Method.GET,url,null,Response.Listener<JSONObject>(){
         fun onResponse(response: JSONObject) {
             mTextViewResult?.append("name")
             val trarr :JSONArray=response.getJSONArray("tram")
             for (i in 0..trarr.length()){
                 val trams: JSONObject=trarr.getJSONObject(i)
                 var id:String=trams.getString("id")
                 var line:String=trams.getString("line")
                 var name:String=trams.getString("name")
                 var type:String=trams.getString("type")
                 var zone:String=trams.getString("zone")
                 var connections:String=trams.getString("connections")
                 var lat:String=trams.getString("lat")
                 var lon:String=trams.getString("lon")
                 mTextViewResult?.append(name)
             }


         }
        }, Response.ErrorListener { 

        })
        mQueue?.add(request)
    }
}