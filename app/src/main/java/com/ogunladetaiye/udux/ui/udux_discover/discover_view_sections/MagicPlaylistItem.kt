package com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections

import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.data.cache.entities.MagicPlaylistEntity
import com.ogunladetaiye.udux.databinding.MagicPlaylistLayoutItemBinding
import com.xwray.groupie.databinding.BindableItem

class MagicPlaylistItem(private val magicPlaylistEntity: MagicPlaylistEntity): BindableItem<MagicPlaylistLayoutItemBinding>(){

    override fun bind(viewBinding: MagicPlaylistLayoutItemBinding, position: Int) {
        viewBinding.magicplaylist = magicPlaylistEntity
    }

    override fun getLayout()= R.layout.magic_playlist_layout_item
}