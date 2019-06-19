package com.example.sentrkk.teknassyon.model

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sentrkk.teknassyon.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), Callback<MovieModel> {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        //  TODO  layout manager to xml
        recyclerView!!.layoutManager = LinearLayoutManager(this,  RecyclerView.VERTICAL, false)
        ApiClient.apiInterface.getAlbum(HttpConstants.API_KEY).enqueue(this)
    }

    override fun onFailure(call: Call<MovieModel>?, t: Throwable?) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
    }


    // TODO ---> view model
    override fun onResponse(call: Call<MovieModel>?, response: Response<MovieModel>?) {
        if (response!!.isSuccessful) {



            var recyclerAdapter = response.body()?.results!!.let { RecyclerViewAdapter(this, it) }
            recyclerView!!.adapter = recyclerAdapter

        }
    }
}
