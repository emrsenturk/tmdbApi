package com.example.sentrkk.teknassyon

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_movie.view.*

class movieAdapter ( val movies : List<movie>) :RecyclerView.Adapter<movieAdapter.movieViewHolder> (){

    //Adapter ' ı kullanacagımız yeri tanımlıcaz
    //adapter, elimizdeki veriyi, görsel arayüzde o veriye ihtiyaç duyan View’a bağlar.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
      return movieViewHolder(


            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_movie, parent,false)
      )
    }

    override fun getItemCount() = movies.size //size of our list

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) { //views of our data databinding
            //hangi sırada hangi view ı göstereceğimize karar veriyoruz positon ile

        val movie = movies[position]

        holder.view.textViewTitle.text = movie.title
        holder.view.textViewLanguage.text = movie.language
        holder.view.textViewType.text = movie.type
        holder.view.textViewRating.text = movie.rating
        holder.view.textViewLikePercent.text = movie.likePercent.toString() + "%"
        holder.view.textViewVotesCount.text = movie.voteCount.toString() + "votes"

        //to do ; how do I use liveData in this code snippet part
        holder.view.textViewIsNew.visibility = if (movie.isNew) View.VISIBLE else View.INVISIBLE
    }




    class movieViewHolder(val  view : View) : RecyclerView.ViewHolder(view)
}