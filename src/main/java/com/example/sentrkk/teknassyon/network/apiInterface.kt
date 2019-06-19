package com.example.sentrkk.teknassyon.model


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface ApiInterface {

    //this interface is provide to get and implement http address.
    @GET("popular?")
    fun getAlbum(@Query("api_key") api_key: String): Call<MovieModel>
}