package com.example.myapplication.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Response
interface TramInterface {
    @GET("/b1bc4a35-7fcb-4faf-a92e-ea763b760326")

     suspend fun getTramData(): Response<List<Tram>>
}