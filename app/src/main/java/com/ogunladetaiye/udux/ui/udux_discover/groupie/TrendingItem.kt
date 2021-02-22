package com.ogunladetaiye.udux.ui.udux_discover.groupie

import com.ogunladetaiye.udux.R
import com.ogunladetaiye.udux.data.cache.entities.TrendingEntity
import com.ogunladetaiye.udux.databinding.TrendingLayoutItemBinding
import com.xwray.groupie.databinding.BindableItem

class TrendingItem(private val trendingEntity: TrendingEntity):BindableItem<TrendingLayoutItemBinding>() {
    override fun bind(viewBinding: TrendingLayoutItemBinding, position: Int) {
       viewBinding.trendingEntity = trendingEntity
    }

    override fun getLayout() = R.layout.trending_layout_item
}