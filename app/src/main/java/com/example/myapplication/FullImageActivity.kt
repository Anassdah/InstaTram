package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

internal class FullImageActivity : AppCompatActivity() {
    //variables declaration
    var position = 0
    var imageView: ImageView? = null
    var imageLink: String? = null
    var myImage: ArrayList<Parcelable>? = null
    var prebuttonfab: FloatingActionButton? = null
    var nextbutton: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        imageView = findViewById(R.id.fullImageViewId)
        prebuttonfab = findViewById(R.id.previoursfabId)
        nextbutton = findViewById(R.id.nextfabId)
        val bundle = intent.extras
        if (bundle != null) {
            myImage = bundle.getParcelableArrayList<Parcelable>("imageList")
            position = bundle.getInt("pos", 0)
            imageLink = bundle.getString("image")
        }
        imageView?.setImageURI(Uri.parse(imageLink))
        prebuttonfab?.setOnClickListener(View.OnClickListener {
            position = if (position - 1 < 0) myImage!!.size - 1 else position - 1
            imageView?.setImageURI(Uri.parse(myImage!![position].toString()))
        })
        //for moving from a picture to another
        nextbutton?.setOnClickListener(View.OnClickListener {
            position = (position + 1) % myImage!!.size
            imageView?.setImageURI(Uri.parse(myImage!![position].toString()))
        })
    }
}