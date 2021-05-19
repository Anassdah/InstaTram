package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_picture_list.*
import java.io.File
import java.io.IOException
import java.lang.Integer.min
import java.text.SimpleDateFormat
import java.util.*

class PictureListActivity : AppCompatActivity() {
    private val IMAGE_CAPTURE_CODE: Int = 1001
    private val PERMISSION_CODE: Int = 1000
    lateinit var imageFilePath: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_list)
        //button click

        camera_button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_DENIED
                    || checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission was not enabled
                    val permission = arrayOf(
                        android.Manifest.permission.CAMERA,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    //show popup to request permission
                    requestPermissions(permission, PERMISSION_CODE)
                } else {//permission already granted
                    openCamera()
                }
            } else {//below marshmallow version
                openCamera()
            }
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //called after the pop up
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission was granted
                    openCamera()
                } else {//permission was denied
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //called when image was captured
        if (resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "image created succesfully", Toast.LENGTH_SHORT).show()
            click_image.setImageBitmap(setScaledBitmap())


            /* click_image.setImageURI(image_uri)
             Picasso.get().load(image_uri).resize(300, 400).centerCrop().into(click_image)*/
            /*val imageBitmap = data?.extras?.get("data") as Bitmap
            click_image.setImageBitmap(imageBitmap)*/


        }

    }

    lateinit var currentPhotoPath: String

    @SuppressLint("SimpleDateFormat")
    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_${timeStamp}_"
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!storageDir?.exists()!!) {
            storageDir.mkdir()
        }
        val imageFile = File.createTempFile(imageFileName, ".jpg", storageDir)
        imageFilePath = imageFile.absolutePath
        return imageFile

    }

    fun openCamera() {
        try {
            val imageFile = createImageFile()
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (cameraIntent.resolveActivity(packageManager) != null) {
                val authorities = "$packageName.fileprovider"
                val imageUri = FileProvider.getUriForFile(this, authorities, imageFile)
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
            }
        } catch (e: Exception) {
            Toast.makeText(this, "failed to create file for the image", Toast.LENGTH_SHORT).show()
        }

        /*val values=ContentValues()
        values.put(MediaStore.Images.Media.ALBUM, "New picture test")
        values.put(MediaStore.Images.Media.TITLE, "New picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "from the camera")
        image_uri=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //Camera Intent
        val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
*/
    }

    fun setScaledBitmap(): Bitmap {
        val imageViewWidth = click_image.width
        val imageViewHeight = click_image.height

        val bOptions = BitmapFactory.Options()
        bOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(imageFilePath, bOptions)
        val bitmapWidth = bOptions.outWidth
        val bitmapHeight = bOptions.outHeight
        val scaleFactor =
            kotlin.math.min(bitmapWidth / imageViewWidth, bitmapHeight / imageViewHeight)
        bOptions.inSampleSize = scaleFactor
        bOptions.inJustDecodeBounds = false
        return BitmapFactory.decodeFile(imageFilePath, bOptions)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId
        if (id==R.id.menu_home){
            Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,HActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.menu_map){
            Toast.makeText(this,"Map", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_language){
            Toast.makeText(this,"Language", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_theme){
            Toast.makeText(this,"Theme", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}



