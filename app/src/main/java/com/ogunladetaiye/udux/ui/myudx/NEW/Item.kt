package com.ogunladetaiye.udux.ui.myudx.NEW


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("admin")
    val admin: Any?,
    @SerializedName("android")
    val android: String,
    @SerializedName("artists")
    val artists: Artists,
    @SerializedName("artwork")
    val artwork: String,
    @SerializedName("artwork_full")
    val artworkFull: String,
    @SerializedName("connected")
    val connected: Int,
    @SerializedName("cp")
    val cp: String,
    @SerializedName("created")
    val created: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("ios")
    val ios: String,
    @SerializedName("isPromo")
    val isPromo: Boolean,
    @SerializedName("Language")
    val language: String,
    @SerializedName("listened")
    val listened: Int,
    @SerializedName("modified")
    val modified: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("objectID")
    val objectID: String,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("perms")
    val perms: List<String>,
    @SerializedName("playlist_custom_tag")
    val playlistCustomTag: List<String>,
    @SerializedName("playlist_tag")
    val playlistTag: List<String>,
    @SerializedName("playlist_type")
    val playlistType: String,
    @SerializedName("public")
    val `public`: Boolean,
    @SerializedName("publishDate")
    val publishDate: Long,
    @SerializedName("sharelink")
    val sharelink: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("streamed")
    val streamed: Int,
    @SerializedName("streams")
    val streams: String,
    @SerializedName("track_count")
    val trackCount: Int,
    @SerializedName("tracks")
    val tracks: Tracks,
    @SerializedName("web")
    val web: String
)