package com.ogunladetaiye.udux.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ogunladetaiye.udux.data.cache.entities.*

@Database(entities = [MagicPlaylistEntity::class, FeaturedAlbumEntity::class,TrendingEntity::class,NewMusicEntity::class,PlaylistEntity::class],version = 6,exportSchema = false)
abstract class UduxDatabase: RoomDatabase() {
    abstract fun uduxDao():UduxDao
}