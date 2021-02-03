package com.ogunladetaiye.udux.data.cache

import androidx.room.RoomDatabase

abstract class UduxDatabase: RoomDatabase() {
    abstract fun uduxDao():UduxDao
}