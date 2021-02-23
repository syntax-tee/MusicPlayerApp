package com.ogunladetaiye.udux.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "magic_playlist_tb")
class MagicPlaylistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val title: String,
    val hex: String,
    val artwork:String
)