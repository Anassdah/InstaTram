package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : FragmentActivity (), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    val map:GoogleMap? = null
    val classha = HActivity()
    private lateinit var a: Marker
    private lateinit var b: Marker
    private lateinit var c: Marker
    private lateinit var d: Marker
    private lateinit var e: Marker
    private lateinit var f: Marker
    private lateinit var g: Marker
    private lateinit var hh: Marker
    private lateinit var i: Marker
    private lateinit var j: Marker
    private lateinit var k: Marker
    private lateinit var l: Marker
    private lateinit var m: Marker
    private lateinit var n: Marker
    private lateinit var o: Marker
    private lateinit var p: Marker
    private lateinit var q: Marker
    private lateinit var r: Marker
    private lateinit var s: Marker
    private lateinit var t: Marker
    private lateinit var u: Marker
    private lateinit var v: Marker
    private lateinit var w: Marker
    private lateinit var x: Marker
    private lateinit var y: Marker
    private lateinit var z: Marker
    private lateinit var aa: Marker
    private lateinit var bb: Marker
    private lateinit var cc: Marker
    private lateinit var dd: Marker
    private lateinit var ee: Marker
    private lateinit var ff: Marker
    private lateinit var jj: Marker
    private lateinit var hhh: Marker
    private lateinit var ii: Marker
    private lateinit var gg: Marker
    private lateinit var kk: Marker
    private lateinit var ll: Marker
    private lateinit var mm: Marker
    private lateinit var nn: Marker
    private lateinit var oo: Marker
    private lateinit var pp: Marker
    private lateinit var qq: Marker
    private lateinit var rr: Marker
    private lateinit var ss: Marker
    private lateinit var tt: Marker
    private lateinit var uu: Marker
    private lateinit var vv: Marker
    private lateinit var ww: Marker
    private lateinit var xx: Marker
    private lateinit var yy: Marker
    private lateinit var zz: Marker
    private lateinit var aaa: Marker
    private lateinit var bbb: Marker
    private lateinit var ccc: Marker
    private lateinit var ddd: Marker




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment:SupportMapFragment =
                supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }
    override fun onMapReady(p0: GoogleMap) {
        val azzzzz:LatLng = LatLng(41.3602701633887, 2.06231782329774);
        a = p0?.addMarker( MarkerOptions().position(azzzzz).title("Fontsanta i Fatjó"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(azzzzz))
        a.tag = 0
        val azzzzzz:LatLng = LatLng(41.3646427714853, 2.05883027285289);
        a = p0?.addMarker( MarkerOptions().position(azzzzzz).title("Bon Viatge"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(azzzzzz))
        a.tag = 0
        val azzzzzzzz:LatLng = LatLng(41.3567799975011, 2.06600611840813);
        a = p0?.addMarker( MarkerOptions().position(azzzzzzzz).title("Les Aigües"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(azzzzzzzz))
        a.tag = 0
        val azzzzzzzzz:LatLng = LatLng(41.3573169129495, 2.06967312836759);
        a = p0?.addMarker( MarkerOptions().position(azzzzzzzzz).title("Cornellà Centre"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(azzzzzzzzz))
        a.tag = 0
        val azzzzzzzzzz:LatLng = LatLng(41.3613569139958, 2.07276892190294);
        a = p0?.addMarker( MarkerOptions().position(azzzzzzzzzz).title("Ignasi Iglésias"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(azzzzzzzzzz))
        a.tag = 0
        val azzzzzzzzzzz:LatLng = LatLng(41.3679007086999, 2.063082294656);
        a = p0?.addMarker( MarkerOptions().position(azzzzzzzzzzz).title("La Fontsanta"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(azzzzzzzzzzz))
        a.tag = 0
        val hahaha:LatLng = LatLng(41.3687284566583, 2.07132883760428);
        a = p0?.addMarker( MarkerOptions().position(hahaha).title("Centre Miquel Martí i Pol"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(hahaha))
        a.tag = 0
        val ha:LatLng = LatLng(41.3654342916373, 2.07676925416326);
        a = p0?.addMarker( MarkerOptions().position(ha).title("El Pedró"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(ha))
        a.tag = 0
        val haa:LatLng = LatLng(41.371016220546, 2.07616093808326);
        a = p0?.addMarker( MarkerOptions().position(haa).title("Llevant-Les Planes"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(haa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3696139040304, 2.08086981278302);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Montesa"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3723391899373, 2.07580611668373);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Hospital Sant Joan Despí | TV3"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3727247041924, 2.08392213029834);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("La Sardana"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3767926012985, 2.08850907950424);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Pont d'Esplugues"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3769753769181, 2.09367193246044);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Can Clota"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3795850237938, 2.05268675136945);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Sant Feliu | Consell Comarcal"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3797845985049, 2.06069211974912);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Torreblanca"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3797331039552, 2.06704907259576);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Walden"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3788403536607, 2.07522510789372);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Rambla de Sant Just"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3766500553622, 2.09828528935288);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Can n'Oliveres"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3761025293673, 2.10609197002068);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Can Rigal"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3767026998859, 2.11084261591932);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Ernest Lluch"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3806754902035, 2.11479729860436);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Avinguda de Xile"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3842044554882, 2.11449065372833);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Zona Universitària"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3859950478969, 2.11861755590232);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Palau Reial"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3867212978738, 2.12148246924578);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Pius XII"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3879646699666, 2.12638568304569);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Maria Cristina"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3893437380252, 2.1318359632411);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Numància"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3905049686833, 2.13640433318727);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("L'Illa"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3921819382415, 2.1429899578455);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Francesc Macià"))
        val zoomLevel:Float = 11.0f
        p0?.moveCamera(CameraUpdateFactory.newLatLngZoom(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, zoomLevel));
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3939821425228, 2.18687783955788);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Marina"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3974678467679, 2.18689347916676);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Auditori | Teatre Nacional"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3875861222237, 2.19202375520085);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Ciutadella | Vila Olímpica"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.3902522809999, 2.18849876956405);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Wellington"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4016956114457, 2.18691287534046);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaaa).title("Glòries"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4037827695728, 2.18832202776882);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaaa).title("La Farinera"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.404422411394, 2.19129145611927);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaaa).title("Ca l'Aranyó"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4077813674524, 2.19313333596197);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaaa).title("Can Jaumandreu"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4061358906449, 2.19812707436525);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaaa).title("Pere IV"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4078078590492, 2.20479899638345);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaaa).title("Fluvià"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4114396191256, 2.19795940120491);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaaa).title("Espronceda"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4091992878307, 2.21035287119043);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaaa).title("Selva de Mar"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4153361658307, 2.20324268873208);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaaa).title("Sant Martí de Provençals"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4105620185959, 2.21579346234101);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaaa).title("El Maresme"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaaa:LatLng = LatLng(41.4119528755077, 2.21994703731682);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaaa).title("Fòrum"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaaa:LatLng = LatLng(41.417295577421, 2.21347520456112);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaaa).title("Alfons el Magnànim"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaaa:LatLng = LatLng(41.4153247598517, 2.22298996859334);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaaa).title("Can Llima"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaaa:LatLng = LatLng(41.418651111406, 2.22274993877984);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaaa).title("La Mina"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaaa:LatLng = LatLng(41.4200509841933, 2.20946506199739);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaaa).title("Besòs"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaaa:LatLng = LatLng(41.4189761548633, 2.22624782117548);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaaa).title("Central Tèrmica del Besòs"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaaa:LatLng = LatLng(41.4193521921015, 2.21751032970247);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaaa).title("Parc del Besòs"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaaa:LatLng = LatLng(41.4226073186697, 2.2218633113181);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaaa).title("La Catalana"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaaa))
        a.tag = 0
        val aaaaaaaaa:LatLng = LatLng(41.4274859983148, 2.22530887632893);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaaa).title("Sant Joan Baptista"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaaa))
        a.tag = 0
        val aaaaaaaa:LatLng = LatLng(41.424092262059, 2.23065496122408);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaaa).title("Estació de Sant Adrià"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaaa))
        a.tag = 0
        val aaaaaaa:LatLng = LatLng(41.4304584678793, 2.22290444983689);
        a = p0?.addMarker( MarkerOptions().position(aaaaaaa).title("Encants de Sant Adrià"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaaa))
        a.tag = 0
        val aaaaaa:LatLng = LatLng(41.4349739717875, 2.22778764587606);
        a = p0?.addMarker( MarkerOptions().position(aaaaaa).title("Sant Roc"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaaa))
        a.tag = 0
        val aaaaa:LatLng = LatLng(41.4392645004098, 2.23264400671318);
        a = p0?.addMarker( MarkerOptions().position(aaaaa).title("Gorg"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(aaaaa))
        a.tag = 0




        p0.setOnMarkerClickListener(this)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf : MenuInflater = menuInflater
        inf.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId
        if (id==R.id.menu_home){
            Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,HActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.menu_map){
            Toast.makeText(this,"Map", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_language){
            Toast.makeText(this,"Language", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,LanguageActivity::class.java)
            startActivity(intent)
        }
        if (id==R.id.setting_theme){
            Toast.makeText(this,"Theme", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,ThemeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onMarkerClick(p0: Marker): Boolean {

        // Retrieve the data from the marker.
        val clickCount = p0.tag as? Int

        // Check if a click count was set, then display the click count.
        clickCount?.let {
            val newClickCount = it + 1
            p0.tag = newClickCount
            val intent = Intent(this, PictureListActivity::class.java)
            startActivity(intent)
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false
    }

}