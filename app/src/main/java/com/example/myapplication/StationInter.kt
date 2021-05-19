package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface StationInter {
    @get:GET("/b/6090a297d64cd16802a8e804")
    val trams:Call<List<Stations?>?>?
    companion object{
    const val BASE_URL ="https://api.jsonbin.io/"
}
    }