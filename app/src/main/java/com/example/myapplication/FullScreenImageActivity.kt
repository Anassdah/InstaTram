package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_full_screen_image.*
import java.io.File
import kotlin.math.min

class FullScreenImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val path=intent.getStringExtra(ExtraPath)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)
        Toast.makeText(this, "Displaying last took image in full screen ", Toast.LENGTH_SHORT).show()

        val bitmap = BitmapFactory.decodeFile(path?.toUri().toString())
        //fullScreenImageView.setImageURI(path?.toUri())
        //Picasso.get().load(path?.toUri()).fit().into(fullScreenImageView)
        fullScreenImageView.setImageBitmap(setScaledBitmap())



    }
    //for image measurements
    private fun setScaledBitmap(): Bitmap {


        val bOptions=BitmapFactory.Options()
        bOptions.inJustDecodeBounds=true
        BitmapFactory.decodeFile(path, bOptions)
        val bitmapWidth=bOptions.outWidth
        val bitmapHeight=bOptions.outHeight
        val scaleFactor= min(bitmapWidth / width, bitmapHeight / height)
        bOptions.inSampleSize=scaleFactor
        bOptions.inJustDecodeBounds=false
        return BitmapFactory.decodeFile(path, bOptions)
    }




}