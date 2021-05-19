package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
//salam
//wa3alaykom salammm hhhh
class MainActivity : AppCompatActivity() {
    fun openActivity2(){
        val intent:Intent=Intent(this,MainActivity2::class.java)
        startActivity(intent)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview : TextView = findViewById(R.id.text_view )
        val button: Button=findViewById(R.id.start_app)
        button.setOnClickListener(View.OnClickListener { openActivity2() })
        val text : String="  WELCOME \n         TO \n BARCELONA"
        val ss : SpannableString = SpannableString(text)
        val rdB : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#008B8B"))
        //A
        val ylA : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#100680"))
        val rd1R : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#008B8B"))
        val yl1C : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#900B0B"))
        val rd2E : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#008B8B"))
        val yl2 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#900B0B"))
        val rd3 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#008B8B"))
        val yl3 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#100680"))
        val rd4 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#008B8B"))


        //welcome
        val bl : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#900B0B"))
        //to
        val to : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#008B8B"))

        ss.setSpan(rdB,24,26, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(ylA,26,27, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd1R,27,28, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl1C,28,29, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd2E,29,30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl2,30,31, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd3,31,32, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl3,32,33, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd4,33,34, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(bl,0,20, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(to,20,24, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)






        textview.setText(ss)
    }
}