package com.example.myapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface TramInterface {
    @GET("/b/6090a297d64cd16802a8e804")

     suspend fun getTramData(): Response<List<Tram>>
}