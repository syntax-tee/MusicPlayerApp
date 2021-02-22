package com.ogunladetaiye.udux.ui.udux_discover.adapters

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponseItem
//import com.ogunladetaiye.udux.databinding.MagicPlaylistRowBinding
//
//class MagicPlaylistAdapter(private val inflater: LayoutInflater) : ListAdapter<DiscoverApiResponseItem,MagicPlaylistViewHolder>(DiffCallback){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        MagicPlaylistViewHolder(MagicPlaylistRowBinding.inflate(inflater, parent, false))
//
//    override fun onBindViewHolder(holder: MagicPlaylistViewHolder, position: Int) {
//        return holder.bind(getItem(position))
//    }
//
//
//}
//
//private object DiffCallback : DiffUtil.ItemCallback<DiscoverApiResponseItem>() {
//    override fun areItemsTheSame(oldItem: DiscoverApiResponseItem, newItem: DiscoverApiResponseItem) =
//            oldItem.id == newItem.id
//
//    override fun areContentsTheSame(oldItem: DiscoverApiResponseItem, newItem: DiscoverApiResponseItem) =
//            oldItem.id == newItem.id &&
//                    oldItem.id == newItem.id
//}