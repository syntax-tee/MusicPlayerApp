package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("albumId")
    val albumId: String,
    @SerializedName("albumName")
    val albumName: String,
    @SerializedName("created")
    val created: Long,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("files")
    val files: List<File>,
    @SerializedName("id")
    val id: String,
    @SerializedName("modified")
    val modified: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("perms")
    val perms: List<String>,
    @SerializedName("pictures")
    val pictures: Pictures,
    @SerializedName("releasedate")
    val releasedate: Long,
    @SerializedName("sharelink")
    val sharelink: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("hex")
    val hex: String,
    @SerializedName("artwork")
    val artwork: String,
    @SerializedName("mobile_artwork")
    val mobileArtwork: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("artist_name")
    val artistName: String,
    @SerializedName("source")
    val source: String



)