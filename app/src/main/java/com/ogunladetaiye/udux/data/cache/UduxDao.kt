package com.ogunladetaiye.udux.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ogunladetaiye.udux.data.cache.entities.*


@Dao
interface UduxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFeaturedAlbumEntity(featuredAlbumEntity: FeaturedAlbumEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMagicPlaylistEntity(magicPlaylistEntity: MagicPlaylistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTrendingEntity(trendingEntity: TrendingEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlaylistEntity(playlistEntity: PlaylistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNewMusicEntity(newMusicEntity: NewMusicEntity)

    @Query("SELECT * FROM magic_playlist_tb")
    fun  fetchMagicPlaylistEntity(): LiveData<List<MagicPlaylistEntity>>

    @Query("SELECT * FROM featured_album_tb")
    fun  fetchFeatureAlbumEntity(): LiveData<List<FeaturedAlbumEntity>>

    @Query("SELECT * FROM trending_entity_tb")
    fun  fetchTrendingEntity(): LiveData<List<TrendingEntity>>

    @Query("SELECT * FROM newmusic_entity_tb")
    fun  fetchNewMusicEntity(): LiveData<List<NewMusicEntity>>

    @Query("SELECT * FROM playlist_entity_tb")
    fun  fetchPlaylistEntity(): LiveData<List<PlaylistEntity>>
}