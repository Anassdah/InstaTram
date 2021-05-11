package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : FragmentActivity (), OnMapReadyCallback {
    val map:GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment:SupportMapFragment =
                supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }
    override fun onMapReady(p0: GoogleMap) {
        val barcelona:LatLng = LatLng(41.409037479455215, 2.174012456198342);
        p0?.addMarker( MarkerOptions().position(barcelona).title("barcelona"))
        p0?.moveCamera(CameraUpdateFactory.newLatLng(barcelona))
    }
}