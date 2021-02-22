package com.ogunladetaiye.udux.ui.udux_discover

import com.ogunladetaiye.udux.data.cache.entities.MagicPlaylistEntity
import com.ogunladetaiye.udux.data.cache.entities.NewMusicEntity
import com.ogunladetaiye.udux.data.cache.entities.PlaylistEntity
import com.ogunladetaiye.udux.data.cache.entities.TrendingEntity
import com.ogunladetaiye.udux.ui.udux_discover.groupie.MagicPlaylistItem
import com.ogunladetaiye.udux.ui.udux_discover.groupie.NewMusicItem
import com.ogunladetaiye.udux.ui.udux_discover.groupie.PlaylistItem
import com.ogunladetaiye.udux.ui.udux_discover.groupie.TrendingItem

fun List<MagicPlaylistEntity>.toMagicPlaylistItem():List<MagicPlaylistItem>{
    return this.map {
        MagicPlaylistItem(it)
    }
}

fun List<TrendingEntity>.toTrendingListItem():List<TrendingItem>{
    return this.map {
        TrendingItem(it)
    }
}

fun List<NewMusicEntity>.toNewMusicItem():List<NewMusicItem>{
    return this.map {
        NewMusicItem(it)
    }
}

fun List<PlaylistEntity>.toPlaylistItem():List<PlaylistItem>{
    return this.map {
        PlaylistItem(it)
    }
}