package com.example.sentrkk.teknassyon.model
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sentrkk.teknassyon.R
import com.squareup.picasso.Picasso


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(act).inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.text_list?.setText(movieItem!![position].original_title)
        holder?.image_list?.loadUrl(HttpConstants.IMAGE_URL + movieItem!![position].poster_path as String)
       }
    //holder?.ratingBar?.stepSize(movieItem!![position].vote_average as Double)

    var act: Context? = null
    var movieItem: List<MovieModel.ResultsEntity>? = null

    constructor(recyclerViewActivity: Context, movieList: List<MovieModel.ResultsEntity>) {
        act = recyclerViewActivity
        movieItem = movieList
    }

    override fun getItemCount(): Int {
        return movieItem?.size!!
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var text_list: TextView? = itemView?.findViewById<TextView>(R.id.textMovie)
        var image_list: ImageView? = itemView?.findViewById<ImageView>(R.id.imageMovie)
        var card_list: CardView? = itemView?.findViewById<CardView>(R.id.cardView)
        var ratingBar: RatingBar? = itemView?.findViewById<RatingBar>(R.id.ratingBar)
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }


}