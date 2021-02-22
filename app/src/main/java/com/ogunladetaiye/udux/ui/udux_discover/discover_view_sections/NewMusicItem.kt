package com.ogunladetaiye.udux.ui.udux_discover.discover_view_sections

import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.data.cache.entities.NewMusicEntity
import com.ogunladetaiye.udux.databinding.NewMusicLayoutItemBinding
import com.xwray.groupie.databinding.BindableItem

class NewMusicItem(private val newMusicEntity: NewMusicEntity): BindableItem<NewMusicLayoutItemBinding>(){

    override fun bind(viewBinding: NewMusicLayoutItemBinding, position: Int) {
        viewBinding.newMusicEntity = newMusicEntity
    }

    override fun getLayout()= R.layout.new_music_layout_item
}