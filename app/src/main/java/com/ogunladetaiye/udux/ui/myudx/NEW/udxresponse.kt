package com.ogunladetaiye.udux.ui.myudx.NEW


import com.google.gson.annotations.SerializedName

data class udxresponse(
    @SerializedName("android")
    val android: String,
    @SerializedName("created")
    val created: Int,
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