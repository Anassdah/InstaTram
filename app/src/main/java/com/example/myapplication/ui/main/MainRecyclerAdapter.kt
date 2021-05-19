package com.example.myapplication.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.Tram
class MainRecyclerAdapter(val context: Context,
                          val stations: List<Tram>):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>()
{

    override fun getItemCount() = stations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.station_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val station = stations[position]
        with(holder) {
            nameText?.let {
                it.text = station.name
                it.contentDescription = station.name
            }
            Glide.with(context)
        }
    }
    // 0. Le ViewHolder
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
    }
}