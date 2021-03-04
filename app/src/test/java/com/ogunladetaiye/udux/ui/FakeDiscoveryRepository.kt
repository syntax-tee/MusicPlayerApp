package com.ogunladetaiye.udux.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ogunladetaiye.udux.data.cache.DiscoveryRepository
import com.ogunladetaiye.udux.data.cache.entities.*

class FakeDiscoveryRepository:DiscoveryRepository {

    private val featuredAlbumEntities = mutableListOf<FeaturedAlbumEntity>()
    private val observableAlbumEntity = MutableLiveData<List<FeaturedAlbumEntity>>(featuredAlbumEntities)

    private val featuredMagicPlaylistEntity = mutableListOf<MagicPlaylistEntity>()
    private val observableMagicPlaylistEntity = MutableLiveData<List<MagicPlaylistEntity>>(featuredMagicPlaylistEntity)


    private val featuredTrendingEntity = mutableListOf<TrendingEntity>()
    private val observableTrendingEntity = MutableLiveData<List<TrendingEntity>>(featuredTrendingEntity)


    private val featuredPlaylistEntity = mutableListOf<PlaylistEntity>()
    private val observablePlaylistEntity = MutableLiveData<List<PlaylistEntity>>(featuredPlaylistEntity)


    private val featuredNewMusicEntity = mutableListOf<NewMusicEntity>()
    private val observableNewMusicEntity = MutableLiveData<List<NewMusicEntity>>(featuredNewMusicEntity)

    override suspend fun saveFeaturedAlbums(featuredAlbumEntity: FeaturedAlbumEntity) {
        featuredAlbumEntities.add(featuredAlbumEntity)
    }

    override suspend fun saveMagicPlaylist(playlistEntity: MagicPlaylistEntity) {
        featuredMagicPlaylistEntity.add(playlistEntity)
    }

    override suspend fun saveTrendingMusic(trendingEntity: TrendingEntity) {
       featuredTrendingEntity.add(trendingEntity)
    }

    override suspend fun savePlaylist(playlistEntity: PlaylistEntity) {
       featuredPlaylistEntity.add(playlistEntity)
    }

    override suspend fun saveNeMusic(newMusicEntity: NewMusicEntity) {
        featuredNewMusicEntity.add(newMusicEntity)
    }

    override fun fetchMagicPlaylist(): LiveData<List<MagicPlaylistEntity>> {
        return observableMagicPlaylistEntity
    }

    override fun fetchFeatureAlbums(): LiveData<List<FeaturedAlbumEntity>> {
        return  observableAlbumEntity
    }

    override fun fetchTrendingMusic(): LiveData<List<TrendingEntity>> {
        return observableTrendingEntity
    }

    override fun fetchNewMusic(): LiveData<List<NewMusicEntity>> {
        return observableNewMusicEntity
    }

    override fun fetchPlaylist(): LiveData<List<PlaylistEntity>> {
        return observablePlaylistEntity
    }
}