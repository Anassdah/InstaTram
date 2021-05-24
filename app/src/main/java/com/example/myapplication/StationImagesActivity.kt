package com.example.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.util.ArrayList

class StationImagesActivity : AppCompatActivity(), OnitemClcikListerner {
    //variables declaration
    var myimageFile: ArrayList<File>? = null
    var customAdapter: CustomAdapter? = null
    var mList: MutableList<String>? = null
    var recyclerView: RecyclerView? = null
    lateinit var stationId:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_station_images)
        /**to retrieve id*/
        val station= intent.getStringExtra(ExtraStationFromPicture).toString()
        stationId=station
        /**To change title bar */
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

        recyclerView = findViewById(R.id.recyclerViewId)
        CheckUserPermissions()
        mList = ArrayList()
    }
// to check permission
    fun CheckUserPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_CODE_ASK_PERMISSIONS)
                return
            }
        }
        display() // init the contact list
    }

    //get access to location permission
    private val REQUEST_CODE_ASK_PERMISSIONS = 123
    /**For request permission result*/
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_ASK_PERMISSIONS -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                display() // init the contact list
            } else {
                // Permission Denied
                Toast.makeText(this, "baliz", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
/**For finding the image*/
    private fun findImage(file: File): ArrayList<File> {
        val imageList = ArrayList<File>()
        val imageFile = file.listFiles()
        for (singleimage in imageFile) {
            if (singleimage.isDirectory && !singleimage.isHidden) {
                imageList.addAll(findImage(singleimage))
            } else {
                /**change suffix to search for names ending with dikchi, khli .jpg*/
                if (singleimage.name.endsWith("InstaTram${stationId}.jpg")) {
                    imageList.add(singleimage)
                }
            }
        }
        return imageList
    }
/**For displaying the image list*/
    private fun display() {
        myimageFile = findImage(Environment.getExternalStorageDirectory())
        for (j in myimageFile!!.indices) {
            mList!!.add(myimageFile!![j].toString())
            customAdapter = CustomAdapter(mList!!, this)
            recyclerView!!.adapter = customAdapter
            recyclerView!!.layoutManager = GridLayoutManager(this, 2)
        }
    }
/**For full screen image on click*/
    override fun onClick(position: Int) {
        Toast.makeText(this, "Postion: $position", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, FullImageActivity::class.java)
        intent.putExtra("image", myimageFile!![position].toString())
        intent.putExtra("pos", position)
        intent.putExtra("imageList", myimageFile)
        startActivity(intent)
    }
    /**For menu  */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf : MenuInflater = menuInflater
        inf.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId
        if (id==R.id.menu_home){
            Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,HActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.menu_map){
            Toast.makeText(this,"Map",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_language){
            Toast.makeText(this,"Language",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_theme){
            Toast.makeText(this,"Theme",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
