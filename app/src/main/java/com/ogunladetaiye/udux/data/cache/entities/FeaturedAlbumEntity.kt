package com.ogunladetaiye.udux.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "featured_album_tb")
data class FeaturedAlbumEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val subtitle:String,
    val title:String,
    val mobileArtwork:String)
