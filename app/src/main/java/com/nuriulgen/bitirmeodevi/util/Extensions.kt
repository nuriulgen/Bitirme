package com.nuriulgen.bitirmeodevi.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nuriulgen.bitirmeodevi.R

fun ImageView.showImage(imageUrl: String?, placeholder: CircularProgressDrawable){
    // Placeholder uyguladık.
    val myOptions = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher)

    // Glide extensions olarak oluşturduk.
    Glide.with(context).setDefaultRequestOptions(myOptions).load(imageUrl).into(this)
}

fun showPlaceHolder(context: Context): CircularProgressDrawable{
    // image yüklenene kadar image yerini almak için kullanıyoruz.
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView,url: String?){
    view.showImage(url, showPlaceHolder(view.context))
}