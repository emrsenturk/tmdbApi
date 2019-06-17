package com.example.sentrkk.teknassyon


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val movie = listOf(
            movie(1,"",true,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",true,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",false,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",false,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",true,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",true,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",true,"UA",73,2300,"Captain America","English","3D"),
            movie(1,"",true,"UA",73,2300,"Captain America","English","3D")


            )
        recyclerViewMovies.layoutManager = LinearLayoutManager(this)
        recyclerViewMovies.adapter = movieAdapter(movie)
    }
}
