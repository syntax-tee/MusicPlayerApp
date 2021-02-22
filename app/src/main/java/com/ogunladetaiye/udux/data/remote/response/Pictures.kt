package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class Pictures(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("default_picture")
    val defaultPicture: Boolean,
    @SerializedName("resource_key")
    val resourceKey: String,
    @SerializedName("sizes")
    val sizes: List<Size>,
    @SerializedName("type")
    val type: String,
    @SerializedName("uri")
    val uri: String
)