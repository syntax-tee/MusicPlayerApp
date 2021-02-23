package com.ogunladetaiye.udux.ui.udux_discover.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogunladetaiye.udux.data.cache.CacheRepository
import com.ogunladetaiye.udux.data.cache.entities.*
import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.data.remote.models.FeaturedAlbum
import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponse
import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponseItem
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DiscoverViewModel @ViewModelInject constructor(
    private val uduxApi: UduxApi,
    private val cacheRepository: CacheRepository
) : ViewModel() {

    private val _udxModelItem = MutableLiveData<List<DiscoverApiResponseItem>>()
    val udxModelItem: LiveData<List<DiscoverApiResponseItem>>
        get() = _udxModelItem

    private val _featuredAlbums = MutableLiveData<List<FeaturedAlbum>>()
    val featuredAlbums: LiveData<List<FeaturedAlbum>>
        get() = _featuredAlbums


    private val _showProgressBar = MutableLiveData<Boolean>()
    val showProgressBar = _showProgressBar


    fun discoveryServiceApi() {
        viewModelScope.launch {
            _showProgressBar.value = true
            val discoverApiResponse = uduxApi.discoverMusic()
            saveFeaturedAlbums(discoverApiResponse)
            saveMagicPlaylist(discoverApiResponse)
            saveTrending(discoverApiResponse)
            saveNewMusic(discoverApiResponse)
            savePlaylist()
        }
        _showProgressBar.value = false
    }

    fun saveMagicPlaylist(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true
        viewModelScope.launch {
            val magicPlaylist = async { discoverApiResponseItem.get(1) }
            val playlistItems = magicPlaylist.await()
            for (playlist in playlistItems.items) {
                cacheRepository.saveMagicPlaylist(
                    MagicPlaylistEntity(
                        0,
                        playlist.name,
                        playlist.title,
                        playlist.hex,
                        playlist.artwork
                    )
                )
            }
        }
    }

    fun saveFeaturedAlbums(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true

        viewModelScope.launch {
            val featuredAlbum = async { discoverApiResponseItem.get(0) }
            val featuredAlbumItems = featuredAlbum.await()
            for (featureAlbumItem in featuredAlbumItems.items) {
                cacheRepository.saveFeaturedAlbums(
                    FeaturedAlbumEntity(
                        0,
                        featureAlbumItem.subtitle,
                        featureAlbumItem.title,
                        featureAlbumItem.mobileArtwork
                    )
                )

            }
        }
    }

    fun saveTrending(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true

        viewModelScope.launch {
            val trendingMusic = async { discoverApiResponseItem.get(2) }
            val trendingItems = trendingMusic.await()
            for (trendingSong in trendingItems.items) {
                cacheRepository.saveTrendingMusic(
                    TrendingEntity(
                        0,
                        trendingSong.name,
                        trendingSong.artistName,
                        trendingSong.artwork
                    )
                )
            }
        }
    }


    fun saveNewMusic(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true
        viewModelScope.launch {
            val newMusic = async { discoverApiResponseItem.get(3) }
            val newMusicItems = newMusic.await()
            for (newMusicItem in newMusicItems.items) {
                cacheRepository.saveNeMusic(
                    NewMusicEntity(
                        0,
                        newMusicItem.name,
                        newMusicItem.artistName,
                        newMusicItem.artwork
                    )
                )
            }
        }
    }

    fun savePlaylist() {
        viewModelScope.launch {
            val playlist1 = PlaylistEntity(
                0,
                "Omay Lay",
                "Godly",
                "",
                "http://"
            )

            val playlist2 = PlaylistEntity(
                0,
                "Davido",
                "Fem",
                "",
                "http://"
            )

            cacheRepository.savePlaylist(playlist1)
            cacheRepository.savePlaylist(playlist2)

        }
    }

    fun fetchFeaturedAlbums(): LiveData<List<FeaturedAlbumEntity>> {
        return cacheRepository.fetchFeatureAlbums()
    }

    fun fetchMagicPlaylist(): LiveData<List<MagicPlaylistEntity>> {
        return cacheRepository.fetchMagicPlaylist()

    }

    fun fetchTrendingMusic(): LiveData<List<TrendingEntity>> {
        return cacheRepository.fetchTrendingMusic()
    }


    fun fetchNewMusic(): LiveData<List<NewMusicEntity>> {
        return cacheRepository.fetchNewMusic()
    }

    fun fetchPlaylist(): LiveData<List<PlaylistEntity>> {
        return cacheRepository.fetchPlaylist()
    }

}


