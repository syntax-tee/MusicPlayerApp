package com.ogunladetaiye.udux.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.ogunladetaiye.udux.data.cache.firebase.entities.Playlist

fun MediaMetadataCompat.toSong(): Playlist? {
    return description?.let {
        Playlist(
            it.mediaId ?: "",
            it.title.toString(),
            it.subtitle.toString(),
            it.iconUri.toString(),
            it.mediaUri.toString()
        )
    }
}