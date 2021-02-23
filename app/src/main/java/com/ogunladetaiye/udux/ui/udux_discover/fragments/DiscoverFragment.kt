package com.ogunladetaiye.udux.ui.udux_discover.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.exoplayer.callbacks.Status
import com.ogunladetaiye.udux.ui.udux_discover.adapters.PlaylistAdapter
import com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections.MagicPlaylistItem
import com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections.NewMusicItem
import com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections.TrendingItem
import com.ogunladetaiye.udux.ui.udux_discover.featured_albums_slider.SliderAdapter
import com.ogunladetaiye.udux.ui.udux_discover.featured_albums_slider.SliderData
import com.ogunladetaiye.udux.ui.udux_discover.toMagicPlaylistItem
import com.ogunladetaiye.udux.ui.udux_discover.toNewMusicItem
import com.ogunladetaiye.udux.ui.udux_discover.toTrendingListItem
import com.ogunladetaiye.udux.ui.udux_discover.viewmodels.DiscoverViewModel
import com.ogunladetaiye.udux.ui.udux_discover.viewmodels.PlaylistViewModel
import com.smarteist.autoimageslider.SliderView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.magic_playlist_recyclerview.*
import kotlinx.android.synthetic.main.new_music_recyclerview.*
import kotlinx.android.synthetic.main.playlist_layout_recyclerview.*
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

    @Inject
    lateinit var playlistAdapter: PlaylistAdapter

    private val playlistViewModel: PlaylistViewModel by viewModels()
    val img1 =
        "https://static.udux.com/6ed790b59c902ae4c765b295d16f26fbaaaf26cca16ed9a087066c8328b86ca8.jpg"
    val img2 =
        "https://static.udux.com/588e1eb09ab05046203fc849e51c94db486170712189929b831d31dd6a1f2573.jpg"
    val img3 =
        "https://firebasestorage.googleapis.com/v0/b/static.udux.com/o/https%3A%2Fstatic.udux.com%2F396c817f40f9e9286338a42bb46e3c451807a244d7c1c43be4c544dcf94eebaf.jpg%3Fq%3D9ebf5fb949f5d0b2fd360ec4d4ee05b66f4beeab0e4d58f0a930c1f683ce5447?alt=media&token=da39da19-f4a6-4ca0-9700-a18a19a480ad"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_discover, container, false)
        sliderView = view.findViewById(R.id.slider)
        GlobalScope.launch(Dispatchers.Main) {
            displayFeatureSlider(sliderView)
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
            displayPlaylist()
        }
    }

    fun displayFeatureSlider(sliderView: SliderView) {
        discoverViewModel.fetchFeaturedAlbums().observe(viewLifecycleOwner, {
            it.forEach {
                //   sliderDataArrayList.add(SliderData(it.mobileArtwork, it.title, it.subtitle))
            }
        })

        sliderDataArrayList.add(SliderData(img1, "Olamide", "Badoo"))
        sliderDataArrayList.add(SliderData(img1, "Davido", "A Good Time"))
        sliderDataArrayList.add(SliderData(img1, "Wizkid", "Made in Lagos"))


        sliderAdapter = SliderAdapter(requireActivity(), sliderDataArrayList)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()
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

    private fun displayPlaylist() {
        setupRecyclerView()
        subscribeToObservers()
        playlistAdapter.setItemClickListener {
            playlistViewModel.playOrToggleSong(it)
        }
    }


    private fun setupRecyclerView() = playlistRecyclerview.apply {
        adapter = playlistAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun subscribeToObservers() {
        playlistViewModel.mediaItems.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    allSongsProgressBar.isVisible = false
                    result.data?.let { playlist ->
                        playlistAdapter.playlists = playlist
                    }
                }
                Status.ERROR -> Unit
                Status.LOADING -> allSongsProgressBar.isVisible = true
            }
        }
    }


}