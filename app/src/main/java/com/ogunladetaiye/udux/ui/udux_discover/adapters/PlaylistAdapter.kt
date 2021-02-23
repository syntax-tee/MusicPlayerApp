package com.ogunladetaiye.udux.ui.udux_discover.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.ogunladetaiye.udux.R
import kotlinx.android.synthetic.main.playlist_item.view.*
import javax.inject.Inject

class PlaylistAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseSongAdapter(R.layout.playlist_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.itemView.apply {
            trackTitle.text = playlist.trackTitle
            trackArtist.text = playlist.artistName
            glide.load(playlist.artwork).into(trackImage)
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(playlist)
                }
            }
        }
    }


}
