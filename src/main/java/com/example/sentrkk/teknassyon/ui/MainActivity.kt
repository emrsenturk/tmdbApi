package com.example.sentrkk.teknassyon.ui


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sentrkk.teknassyon.R
import com.example.sentrkk.teknassyon.model.movie
import com.example.sentrkk.teknassyon.network.moviesApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    moviesApi()
        .getMovies().enqueue(object : Callback<List<movie>>{
        override fun onFailure(call: Call<List<movie>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }

        override fun onResponse(call: Call<List<movie>>, response: Response<List<movie>>) {

            val movie = response.body()

            movie?.let {

                showMovies(it)
            }


        }


    })


    }
    private fun showMovies(movie : List<movie>){


        recyclerViewMovies.layoutManager = LinearLayoutManager(this)
        recyclerViewMovies.adapter = movieAdapter(movies = movie)
    }
}
