package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class UduxModelItem(
    @SerializedName("android")
    val android: String,
    @SerializedName("created")
    val created: Long,
    @SerializedName("displayLimit")
    val displayLimit: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("ios")
    val ios: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("modified")
    val modified: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("q")
    val q: List<Any>,
    @SerializedName("sectionIndex")
    val sectionIndex: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("streams")
    val streams: String,
    @SerializedName("target")
    val target: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("undefined")
    val undefined: Undefined,
    @SerializedName("web")
    val web: String
)