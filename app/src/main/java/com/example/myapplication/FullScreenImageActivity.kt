package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_screen_image.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import kotlin.math.min

class FullScreenImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val storageDir: File? = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val path=intent.getStringExtra(ExtraPath)
        val width=intent.getStringExtra(Extrawidth)
        val height=intent.getStringExtra(Extraheight)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        val bitmap = BitmapFactory.decodeFile(path?.toUri().toString())
        //fullScreenImageView.setImageURI(path?.toUri())
        //Picasso.get().load(path?.toUri()).fit().into(fullScreenImageView)
        fullScreenImageView.setImageBitmap(setScaledBitmap())



    }
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