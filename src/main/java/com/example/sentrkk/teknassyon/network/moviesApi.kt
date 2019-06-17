package com.example.sentrkk.teknassyon.network

import com.example.sentrkk.teknassyon.model.movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.simplifiedcoding.in/course-apis/recyclerview/"

interface moviesApi {

    @GET("movies")

    fun getMovies() : Call<List<movie>>

    companion object {
        operator fun invoke() : moviesApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(moviesApi::class.java)
        }
    }
}
