package com.ogunladetaiye.udux.data.cache

import androidx.lifecycle.LiveData
import com.ogunladetaiye.udux.data.cache.entities.*
import javax.inject.Inject

class CacheRepository @Inject constructor(private val udxDao: UduxDao):DiscoveryRepository {

    override suspend fun saveFeaturedAlbums(featuredAlbumEntity: FeaturedAlbumEntity) {
        udxDao.saveFeaturedAlbumEntity(featuredAlbumEntity)
    }

    override suspend fun saveMagicPlaylist(playlistEntity: MagicPlaylistEntity) {
        udxDao.saveMagicPlaylistEntity(playlistEntity)
    }

    override suspend fun saveTrendingMusic(trendingEntity: TrendingEntity) {
        udxDao.saveTrendingEntity(trendingEntity)
    }

    override suspend fun savePlaylist(playlistEntity: PlaylistEntity) {
        udxDao.savePlaylistEntity(playlistEntity)
    }

    override suspend fun saveNeMusic(newMusicEntity: NewMusicEntity) {
        udxDao.saveNewMusicEntity(newMusicEntity)
    }

    override  fun fetchMagicPlaylist(): LiveData<List<MagicPlaylistEntity>> {
       return udxDao.fetchMagicPlaylistEntity()
    }

    override fun fetchFeatureAlbums(): LiveData<List<FeaturedAlbumEntity>> {
      return  udxDao.fetchFeatureAlbumEntity()
    }

    override fun fetchTrendingMusic(): LiveData<List<TrendingEntity>> {
        return udxDao.fetchTrendingEntity()
    }

    override fun fetchNewMusic(): LiveData<List<NewMusicEntity>> {
       return udxDao.fetchNewMusicEntity()
    }

    override fun fetchPlaylist(): LiveData<List<PlaylistEntity>> {
       return udxDao.fetchPlaylistEntity()
    }

}