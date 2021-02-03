package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("height")
    val height: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("link_with_play_button")
    val linkWithPlayButton: String,
    @SerializedName("width")
    val width: Int
)