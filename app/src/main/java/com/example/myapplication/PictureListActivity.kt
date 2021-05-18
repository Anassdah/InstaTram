package com.example.myapplication

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture_list.*
const val REQUEST_IMAGE_CAPTURE = 1
class PictureListActivity : AppCompatActivity() {
    private val IMAGE_CAPTURE_CODE: Int=1001
    private val PERMISSION_CODE: Int=1000
    var image_uri: Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //button click
        val capture_btn=findViewById<ImageButton>(R.id.camera_button)
        capture_btn.setOnClickListener {
            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                if(checkSelfPermission(android.Manifest.permission.CAMERA)==
                    PackageManager.PERMISSION_DENIED
                    || checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission was not enabled
                    val permission = arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    //show popup to request permission
                    requestPermissions(permission, PERMISSION_CODE)}
                else {//permission already granted
                    openCamera()
                }
            }
            else{//below marshmallow version
                openCamera()
            }
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //called after the pop up
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_CODE->{
                if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    //permission was granted
                    openCamera()
                }
                else{//permission was denied
                    Toast.makeText(this,"permission denied", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //called when image was captured
        if(resultCode== Activity.RESULT_OK){
            //set image captured to image image view
            click_image.setImageURI(image_uri)
            Picasso.get().load(image_uri).resize(300, 400).centerCrop().into(click_image)

        }
    }

    private fun openCamera() {

        val values= ContentValues()
        values.put(MediaStore.Images.Media.TITLE,"New picture")
        values.put(MediaStore.Images.Media.DESCRIPTION,"from the camera")
        image_uri=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        //Camera Intent
        val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,image_uri)
        startActivityForResult(cameraIntent,IMAGE_CAPTURE_CODE)

    }
}