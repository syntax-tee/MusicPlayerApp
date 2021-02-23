package com.ogunladetaiye.udux.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "trending_entity_tb")
class TrendingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val artistName: String,
    val artwork:String
)