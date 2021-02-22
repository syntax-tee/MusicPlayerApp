package com.ogunladetaiye.udux.ui.udux_discover.groupie

import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.data.cache.entities.PlaylistEntity
import com.ogunladetaiye.udux.databinding.PlaylistItemBinding
import com.xwray.groupie.databinding.BindableItem

class PlaylistItem(private val playlistEntity: PlaylistEntity): BindableItem<PlaylistItemBinding>() {
    override fun bind(viewBinding: PlaylistItemBinding, position: Int) {
        viewBinding.playListEntity = playlistEntity
    }

    override fun getLayout() = R.layout.playlist_item
}