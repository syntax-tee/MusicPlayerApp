package com.ogunladetaiye.udux.utils

import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide
import com.ogunladetaiye.udux.R

object ImageUtil {

    fun loadImageWithCoil(imageView: ImageView, imageUrl: String){
        imageView.load(imageUrl){
            error(R.drawable.ic_music_library)
        }
    }

    fun loadImageWithGlide(view: ImageView, imageUrl: String?) {
        Glide.with(view.getContext())
            .load(imageUrl)
            .into(view)
    }
}