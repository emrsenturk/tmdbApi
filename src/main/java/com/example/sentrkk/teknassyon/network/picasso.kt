package com.example.sentrkk.teknassyon
import android.content.Context
import com.squareup.picasso.Picasso


public val Context.picasso: Picasso
    get() = Picasso.with(this)