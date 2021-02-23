package com.ogunladetaiye.udux.ui.udux_discover.adapters

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.bumptech.glide.Glide
import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.data.cache.entities.MagicPlaylistEntity


@BindingAdapter("loadViewImage")
fun loadImage(imageView: ImageView, imageUrl: String){
    imageView.load(imageUrl){
        error(R.drawable.ic_music_library)
    }
}


@BindingAdapter("magicPlaylistHoverBackground")
fun backgroundTintBinding(view: View, magicPlaylistEntity: MagicPlaylistEntity) {
    view.setBackgroundColor(Color.parseColor(magicPlaylistEntity.hex))
}


@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.INVISIBLE else View.VISIBLE
}

