package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("created_time")
    val createdTime: String,
    @SerializedName("fps")
    val fps: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("md5")
    val md5: String,
    @SerializedName("public_name")
    val publicName: String,
    @SerializedName("quality")
    val quality: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("size_short")
    val sizeShort: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("width")
    val width: Int
)