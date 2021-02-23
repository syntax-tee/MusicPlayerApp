package com.ogunladetaiye.udux.data.cache

import com.ogunladetaiye.udux.data.cache.entities.*
import javax.inject.Inject

class CacheRepository @Inject constructor(private val udxDao: UduxDao) {

    fun saveFeaturedAlbums(featuredAlbumEntity: FeaturedAlbumEntity) =
        udxDao.saveFeaturedAlbumEntity(featuredAlbumEntity)

    fun saveMagicPlaylist(playlistEntity: MagicPlaylistEntity) =
        udxDao.saveMagicPlaylistEntity(playlistEntity)

    fun saveTrendingMusic(trendingEntity: TrendingEntity) =
        udxDao.saveTrendingEntity(trendingEntity)

    fun savePlaylist(playlistEntity: PlaylistEntity) = udxDao.savePlaylistEntity(playlistEntity)

    fun saveNeMusic(newMusicEntity: NewMusicEntity) = udxDao.saveNewMusicEntity(newMusicEntity)

    fun fetchMagicPlaylist() = udxDao.fetchMagicPlaylistEntity()

    fun fetchFeatureAlbums() = udxDao.fetchFeatureAlbumEntity()

    fun fetchTrendingMusic() = udxDao.fetchTrendingEntity()

    fun fetchNewMusic() = udxDao.fetchNewMusicEntity()

    fun fetchPlaylist() = udxDao.fetchPlaylistEntity()


}