package com.ogunladetaiye.udux.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist_entity_tb")
class PlaylistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val artistName: String,
    val trackTitle:String,
    val artwork:String,
    val trackUrl:String
)