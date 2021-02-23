package com.ogunladetaiye.udux.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newmusic_entity_tb")
class NewMusicEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val artistName: String,
    val artwork:String
)