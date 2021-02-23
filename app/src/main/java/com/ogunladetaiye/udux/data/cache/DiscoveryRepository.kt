package com.ogunladetaiye.udux.data.cache

import androidx.lifecycle.LiveData
import com.ogunladetaiye.udux.data.cache.entities.*

interface DiscoveryRepository {

    suspend fun saveFeaturedAlbums(featuredAlbumEntity: FeaturedAlbumEntity)

    suspend fun saveMagicPlaylist(playlistEntity: MagicPlaylistEntity)

    suspend fun saveTrendingMusic(trendingEntity: TrendingEntity)

    suspend fun savePlaylist(playlistEntity: PlaylistEntity)

    suspend fun saveNeMusic(newMusicEntity: NewMusicEntity)

    fun fetchMagicPlaylist(): LiveData<List<MagicPlaylistEntity>>

    fun fetchFeatureAlbums(): LiveData<List<FeaturedAlbumEntity>>

    fun fetchTrendingMusic(): LiveData<List<TrendingEntity>>

    fun fetchNewMusic(): LiveData<List<NewMusicEntity>>

    fun fetchPlaylist(): LiveData<List<PlaylistEntity>>


}

