package com.ogunladetaiye.udux.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ogunladetaiye.udux.utils.Constants.UTILITIES

@Entity(tableName = UTILITIES)
data class Utilities(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val artWork:String,
    val title:String,
    val name:String,
    val hex:String
)
