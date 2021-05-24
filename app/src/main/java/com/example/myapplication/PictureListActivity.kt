package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_picture_list.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


/**var and const declarations*/
//intent keys
const val ExtraPath="com.example.myfirstapp.path"
const val Extrawidth="com.example.myfirstapp.width"
const val Extraheight="com.example.myfirstapp.height"
const val ExtraStationFromPicture="com.example.myapplication.stationame"
//path declaration
lateinit var path:String
//for our image
var width=0
var height=0

@Suppress("DEPRECATION")
class PictureListActivity : AppCompatActivity() {
    //for user permission and image capture
    private val IMAGE_CAPTURE_CODE: Int=1001
    private val PERMISSION_CODE: Int=1000
    lateinit var imageFilePath:String
    lateinit var stationId:String
    // var image_uri:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_list)
        val toast = Toast.makeText(this, "Click here to display last took image", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
        val station= intent.getStringExtra(ExtraStation).toString()
        stationId=station
        // to change title bar
        when (station) {
            "0" -> this.title = "Fontsanta Fatjo"
            "1" -> this.title = "Bon Viatge"
            "2" -> this.title = "Les Aigües"
            "3" -> this.title = "Cornellà Centre"
            "4" -> this.title = "Ignasi Iglésias"
            "5" -> this.title = "La Fontsanta"
            "6" -> this.title = "Centre Miquel Marti i Pol"
            "7" -> this.title = "El Pedró"
            "8" -> this.title = "Llevant-Les Planes"
            "9" -> this.title = "Montesa"
            "10" -> this.title = "Hospital Sant Joan Despí | TV3"
            "11" -> this.title = "La Sardana"
            "12" -> this.title = "Pont d'Esplugues"
            "13" -> this.title = "Can Clota"
            "14" -> this.title = "Sant Feliu | Consell Comarcal"
            "15" -> this.title = "Torreblanca"
            "16" -> this.title = "Walden"
            "17" -> this.title = "Rambla de Sant Just"
            "18" -> this.title = "Can n'Oliveres"
            "19" -> this.title = "Can Rigal"
            "20" -> this.title = "Ernest Lluch"
            "21" -> this.title = "Avinguda de Xile"
            "22" -> this.title = "Zona Universitària"
            "23" -> this.title = "Palau Reial"
            "24" -> this.title = "Pius XII"
            "25" -> this.title = "Maria Cristina"
            "27" -> this.title = "L'Illa"
            "28" -> this.title = "Francesc Macià"
            "29" -> this.title = "Marina"
            "30" -> this.title = "Auditori | Teatre Nacional"
            "31" -> this.title = "Ciutadella | Vila Olímpica"
            "32" -> this.title = "Wellington"
            "33" -> this.title = "Glòries"
            "34" -> this.title = "La Farinera"
            "35" -> this.title = "Ca l'Aranyó"
            "36" -> this.title = "Can Jaumandreu"
            "37" -> this.title = "Pere IV"
            "38" -> this.title = "Fluvià"
            "39" -> this.title = "Espronceda"
            "40" -> this.title = "Selva de Mar"
            "41" -> this.title = "Sant Martí de Provençals"
            "42" -> this.title = "El Maresme"
            "43" -> this.title = "Fòrum"
            "44" -> this.title = "Alfons el Magnànim"
            "45" -> this.title = "Can Llima"
            "46" -> this.title = "La Mina"
            "47" -> this.title = "Besòs"
            "48" -> this.title = "Parc del Besòs"
            "49" -> this.title = "Central Tèrmica del Besòs"
            "50" -> this.title = "La Catalana"
            "51" -> this.title = "Sant Joan Baptista"
            "52" -> this.title = "Estació de Sant Adrià"
            "53" -> this.title = "Encants de Sant Adrià"
            "54" -> this.title = "Sant Roc"
            "55" -> this.title = "Gorg"
        }
        /**camera button setup*/

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
            //to get the path
            path=imageFilePath
            Toast.makeText(this, "Image created successfully", Toast.LENGTH_SHORT).show()
            click_image.setImageBitmap(setScaledBitmap())




            /* click_image.setImageURI(image_uri)
             Picasso.get().load(image_uri).resize(300, 400).centerCrop().into(click_image)*/
            /*val imageBitmap = data?.extras?.get("data") as Bitmap
            click_image.setImageBitmap(imageBitmap)*/


        }

    }

    @SuppressLint("SimpleDateFormat")
    @Throws(IOException::class)
    /**Image file creation*/
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Date())
        val imageFileName = "InstaTram_${timeStamp}_"
        //val imageFileName="InstaTram"
        //set the file path
        val storageDir: File? = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if(!storageDir?.exists()!!){storageDir.mkdir()}
        /**change suffix to change name khli .jpg*/
        val imageFile= createTempFile(imageFileName, "InstaTram${stationId}.jpg", storageDir)
        imageFilePath=imageFile.absolutePath
        return imageFile

    }
/**To open camera*/
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

/**For image mesurement in capture*/
    private fun setScaledBitmap():Bitmap{
        width=click_image.width
        height=click_image.height

        val bOptions=BitmapFactory.Options()
        bOptions.inJustDecodeBounds=true
        BitmapFactory.decodeFile(imageFilePath, bOptions)
        val bitmapWidth=bOptions.outWidth
        val bitmapHeight=bOptions.outHeight
        val scaleFactor= kotlin.math.min(bitmapWidth / width, bitmapHeight / height)
        bOptions.inSampleSize=scaleFactor
        bOptions.inJustDecodeBounds=false
        return BitmapFactory.decodeFile(imageFilePath, bOptions)
    }

    /**for full image display*/
    fun OnClickImage(view: View) {
        val fullScreenIntent = Intent(this, FullScreenImageActivity::class.java).apply {
            putExtra(ExtraPath, path.toString())
            putExtra(Extraheight, height.toString())
            putExtra(Extrawidth, width.toString())
        }
        startActivity(fullScreenIntent)
    }
    /**For displaying station image list*/

    fun OnClickImageList(view: View){
        val imageListIntent = Intent(this, StationImagesActivity::class.java).apply {
            putExtra(ExtraStationFromPicture, stationId)
        }
        startActivity(imageListIntent)


    }

    /**For menu*/
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId
        if (id==R.id.menu_home){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.menu_map){
            Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_language){
            Toast.makeText(this, "Language", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_theme){
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}



