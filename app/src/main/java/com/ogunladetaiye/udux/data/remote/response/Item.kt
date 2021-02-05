package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("albumId")
    val albumId: String?,
    @SerializedName("albumName")
    val albumName: String?,
    @SerializedName("artist_ids")
    val artistIds: List<String>?,
    @SerializedName("created")
    val created: Long?,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("endDate")
    val endDate: Long?,
    @SerializedName("files")
    val files: List<File>?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isLivestream")
    val isLivestream: Boolean?,
    @SerializedName("modified")
    val modified: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("perms")
    val perms: List<String>?,
    @SerializedName("pictures")
    val pictures: Pictures?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("priceId")
    val priceId: String?,
    @SerializedName("relatedAlbum")
    val relatedAlbum: String?,
    @SerializedName("releasedate")
    val releasedate: Long?,
    @SerializedName("sharelink")
    val sharelink: String?,
    @SerializedName("startDate")
    val startDate: Long?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("uri")
    val uri: String?
)