package com.ogunladetaiye.udux.utils

import android.widget.ImageView
import coil.load
import com.ogunladetaiye.udux.R

object ImageUtil {

    fun loadImageWithCoil(imageView: ImageView, imageUrl: String){
        imageView.load(imageUrl){
            error(R.drawable.ic_error_placeholder)
        }
    }
}