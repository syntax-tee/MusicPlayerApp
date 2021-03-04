package com.ogunladetaiye.udux.ui.udux_discover.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogunladetaiye.udux.data.cache.DiscoveryRepository
import com.ogunladetaiye.udux.data.cache.entities.*
import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.data.remote.models.FeaturedAlbum
import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponse
import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponseItem
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DiscoverViewModel @ViewModelInject constructor(
    private val uduxApi: UduxApi,
    private val discoveryRepository: DiscoveryRepository
) : ViewModel() {

    private val _udxModelItem = MutableLiveData<List<DiscoverApiResponseItem>>()
    val udxModelItem: LiveData<List<DiscoverApiResponseItem>>
        get() = _udxModelItem

    private val _featuredAlbums = MutableLiveData<List<FeaturedAlbum>>()
    val featuredAlbums: LiveData<List<FeaturedAlbum>>
        get() = _featuredAlbums


    private val _showProgressBar = MutableLiveData<Boolean>()
    val showProgressBar = _showProgressBar


    init {
        _showProgressBar.postValue(true)
    }

    fun discoveryServiceApi() {
        viewModelScope.launch {
            _showProgressBar.value = true
            val discoverApiResponse = uduxApi.discoverMusic()
            fetchFeaturedAlbumFromApi(discoverApiResponse)
            fetchMagicPlaylistFromApi(discoverApiResponse)
            fetchTrendingMusicFromApi(discoverApiResponse)
            fetchNewMusicFromApi(discoverApiResponse)
            savePlaylist()
            _showProgressBar.value = false
        }
    }

    fun fetchMagicPlaylistFromApi(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true
        viewModelScope.launch {
            val magicPlaylist = async { discoverApiResponseItem.get(1) }
            val playlistItems = magicPlaylist.await()
            for (playlist in playlistItems.items) {
                saveMagicPlaylist(
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

    fun fetchFeaturedAlbumFromApi(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true

        viewModelScope.launch {
            val featuredAlbum = async { discoverApiResponseItem.get(0) }
            val featuredAlbumItems = featuredAlbum.await()
            for (featureAlbumItem in featuredAlbumItems.items) {
                fetchFeaturedAlbumFromApi(
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


    fun fetchTrendingMusicFromApi(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true

        viewModelScope.launch {
            val trendingMusic = async { discoverApiResponseItem.get(2) }
            val trendingItems = trendingMusic.await()
            for (trendingSong in trendingItems.items) {
                saveTrendingMusic(
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

    suspend fun saveTrendingMusic(trendingEntity: TrendingEntity) {
        discoveryRepository.saveTrendingMusic(trendingEntity)
    }

    suspend fun saveMagicPlaylist(magicPlaylistEntity: MagicPlaylistEntity) {
        discoveryRepository.saveMagicPlaylist(magicPlaylistEntity)
    }

    suspend fun fetchFeaturedAlbumFromApi(featuredAlbumEntity: FeaturedAlbumEntity) {
        discoveryRepository.saveFeaturedAlbums(featuredAlbumEntity)
    }

    suspend fun saveNewMusic(newMusicEntity: NewMusicEntity) {
        discoveryRepository.saveNeMusic(newMusicEntity)
    }

    fun fetchNewMusicFromApi(discoverApiResponseItem: DiscoverApiResponse) {
        _showProgressBar.value = true
        viewModelScope.launch {
            val newMusic = async { discoverApiResponseItem.get(3) }
            val newMusicItems = newMusic.await()
            for (newMusicItem in newMusicItems.items) {
                saveNewMusic(
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

            discoveryRepository.savePlaylist(playlist1)
            discoveryRepository.savePlaylist(playlist2)

        }
    }

    fun fetchFeaturedAlbums(): LiveData<List<FeaturedAlbumEntity>> {
        return discoveryRepository.fetchFeatureAlbums()
    }

    fun fetchMagicPlaylist(): LiveData<List<MagicPlaylistEntity>> {
        return discoveryRepository.fetchMagicPlaylist()

    }

    fun fetchTrendingMusic(): LiveData<List<TrendingEntity>> {
        return discoveryRepository.fetchTrendingMusic()
    }


    fun fetchNewMusicFromApi(): LiveData<List<NewMusicEntity>> {
        return discoveryRepository.fetchNewMusic()
    }

    fun fetchPlaylist(): LiveData<List<PlaylistEntity>> {
        return discoveryRepository.fetchPlaylist()
    }

}


