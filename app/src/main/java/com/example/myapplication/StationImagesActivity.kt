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
        when (station) {
            "0" -> this.setTitle("Fontsanta Fatjo")
            "1" -> this.setTitle("Bon Viatge")
            "2" -> this.setTitle("Les Aigües")
            "3" -> this.setTitle("Cornellà Centre")
            "4" -> this.setTitle("Ignasi Iglésias")
            "5" -> this.setTitle("La Fontsanta")
            "6" -> this.setTitle("Centre Miquel Marti i Pol")
            "7" -> this.setTitle("El Pedró")
            "8" -> this.setTitle("Llevant-Les Planes")
            "9" -> this.setTitle("Montesa")
            "10" -> this.setTitle("Hospital Sant Joan Despí | TV3")
            "11" -> this.setTitle("La Sardana")
            "12" -> this.setTitle("Pont d'Esplugues")
            "13" -> this.setTitle("Can Clota")
            "14" -> this.setTitle("Sant Feliu | Consell Comarcal")
            "15" -> this.setTitle("Torreblanca")
            "16" -> this.setTitle("Walden")
            "17" -> this.setTitle("Rambla de Sant Just")
            "18" -> this.setTitle("Can n'Oliveres")
            "19" -> this.setTitle("Can Rigal")
            "20" -> this.setTitle("Ernest Lluch")
            "21" -> this.setTitle("Avinguda de Xile")
            "22" -> this.setTitle("Zona Universitària")
            "23" -> this.setTitle("Palau Reial")
            "24" -> this.setTitle("Pius XII")
            "25" -> this.setTitle("Maria Cristina")
            "26" -> this.setTitle("Numància")
            "27" -> this.setTitle("Numància")
            "28" -> this.setTitle("Numància")
            "29" -> this.setTitle("Numància")
            "30" -> this.setTitle("Numància")
            "31" -> this.setTitle("Numància")
            "32" -> this.setTitle("Numància")
            "33" -> this.setTitle("Numància")
            "34" -> this.setTitle("Numància")
            "35" -> this.setTitle("Numància")
            "36" -> this.setTitle("Numància")
            "37" -> this.setTitle("Numància")
            "38" -> this.setTitle("Numància")
        }

        recyclerView = findViewById(R.id.recyclerViewId)
        CheckUserPermsions()
        mList = ArrayList()
    }

    fun CheckUserPermsions() {
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

    //get acces to location permsion
    private val REQUEST_CODE_ASK_PERMISSIONS = 123
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

    private fun display() {
        myimageFile = findImage(Environment.getExternalStorageDirectory())
        for (j in myimageFile!!.indices) {
            mList!!.add(myimageFile!![j].toString())
            customAdapter = CustomAdapter(mList!!, this)
            recyclerView!!.adapter = customAdapter
            recyclerView!!.layoutManager = GridLayoutManager(this, 2)
        }
    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "Postion: $position", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, FullImageActivity::class.java)
        intent.putExtra("image", myimageFile!![position].toString())
        intent.putExtra("pos", position)
        intent.putExtra("imageList", myimageFile)
        startActivity(intent)
    }
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
