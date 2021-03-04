package com.ogunladetaiye.udux.ui.udux_discover.fragments

import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.data.cache.firebase.entities.Song
import com.ogunladetaiye.udux.exoplayer.callbacks.Status
import com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections.MagicPlaylistItem
import com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections.NewMusicItem
import com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections.TrendingItem
import com.ogunladetaiye.udux.ui.udux_discover.featured_albums_slider.SliderAdapter
import com.ogunladetaiye.udux.ui.udux_discover.featured_albums_slider.SliderData
import com.ogunladetaiye.udux.ui.udux_discover.toMagicPlaylistItem
import com.ogunladetaiye.udux.ui.udux_discover.toNewMusicItem
import com.ogunladetaiye.udux.ui.udux_discover.toTrendingListItem
import com.ogunladetaiye.udux.ui.udux_discover.viewmodels.DiscoverViewModel
import com.ogunladetaiye.udux.ui.udux_discover.viewmodels.MainViewModel
import com.ogunladetaiye.udux.ui.udux_discover.adapters.SongAdapter
import com.smarteist.autoimageslider.SliderView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.magic_playlist_recyclerview.*
import kotlinx.android.synthetic.main.new_music_recyclerview.*
import kotlinx.android.synthetic.main.songlist_layout_recyclerview.*
import kotlinx.android.synthetic.main.trending_layout_recyclerview.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class DiscoverFragment : Fragment() {

    private val discoverViewModel: DiscoverViewModel by viewModels()
    val sliderDataArrayList: ArrayList<SliderData> = ArrayList()
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter


    private var curPlayingSong: Song? = null

    private var playbackState: PlaybackStateCompat? = null

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var songAdapter: SongAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_discover, container, false)
        val imageSlider = view.findViewById<ImageSlider>(R.id.slider)
        GlobalScope.launch(Dispatchers.Main) {
            displayFeatureSlider(imageSlider)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            discoverViewModel.discoveryServiceApi()
            displayMagicPlaylist()
            displayTrendingMusic()
            displayNewMusic()
        }

        setupRecyclerView()
        subscribeToObservers()

        songAdapter.setItemClickListener {
            mainViewModel.playOrToggleSong(it)
        }
    }


    fun displayFeatureSlider(imageSlider: ImageSlider) {
        val imageList = ArrayList<SlideModel>()
        discoverViewModel.fetchFeaturedAlbums().observe(viewLifecycleOwner, {
            it.forEach {
                imageList.add(SlideModel(it.mobileArtwork,it.title +" "+ it.subtitle, ScaleTypes.FIT))
            }
            imageSlider.setImageList(imageList)
        })
    }


    fun displayMagicPlaylist() {
        discoverViewModel.fetchMagicPlaylist().observe(viewLifecycleOwner, Observer {
            initMagicPlaylist(it.toMagicPlaylistItem())
        })
    }

    fun displayTrendingMusic() {
        discoverViewModel.fetchTrendingMusic().observe(viewLifecycleOwner, Observer {
            initTrendingMusic(it.toTrendingListItem())
        })
    }

    fun displayNewMusic() {
        discoverViewModel.fetchNewMusicFromApi().observe(viewLifecycleOwner, Observer {
            initNewMusic(it.toNewMusicItem())
        })
    }


    private fun initMagicPlaylist(magicPlaylist: List<MagicPlaylistItem>) {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(magicPlaylist)
        }
        magicPlaylistRecyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    fun initTrendingMusic(trendingItem: List<TrendingItem>) {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(trendingItem)
        }
        trendingRecyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }


    fun initNewMusic(newMusicItem: List<NewMusicItem>) {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(newMusicItem)
        }
        newMusicRecyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun setupRecyclerView() = rvAllSongs.apply {
        adapter = songAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun subscribeToObservers() {
        mainViewModel.mediaItems.observe(viewLifecycleOwner) { result ->
            when(result.status) {
                Status.SUCCESS -> {
                    allSongsProgressBar.isVisible = false
                    result.data?.let { songs ->
                        songAdapter.songs = songs
                    }
                }
                Status.ERROR -> Unit
                Status.LOADING -> allSongsProgressBar.isVisible = true
            }
        }
    }



}