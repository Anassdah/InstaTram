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
        val rd : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#EA2C2C"))
        val rd1 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#EA2C2C"))
        val rd2 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#EA2C2C"))
        val rd3 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#EA2C2C"))
        val rd4 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#EA2C2C"))
        val yl1 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#0A15E4"))
        val yl2 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#0A15E4"))
        val yl3 : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#0A15E4"))
        val yl : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#0A15E4"))
        val bl : ForegroundColorSpan= ForegroundColorSpan(Color.parseColor("#EA2C2C"))

        ss.setSpan(rd,24,26, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl,26,27, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd1,27,28, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl1,28,29, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd2,29,30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl2,30,31, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd3,31,32, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(yl3,32,33, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(rd4,33,34, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(bl,0,24, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)






        textview.setText(ss)
    }
}