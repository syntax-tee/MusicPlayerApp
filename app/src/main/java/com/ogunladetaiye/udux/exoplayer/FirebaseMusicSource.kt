package com.ogunladetaiye.udux.exoplayer

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.MediaMetadataCompat.*
import androidx.core.net.toUri
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.ogunladetaiye.udux.data.cache.firebase.MusicDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseMusicSource @Inject constructor(
    private val musicDatabase: MusicDatabase
) {

    private val onReadyListeners = mutableListOf<(Boolean) -> Unit>()

    var playlists = emptyList<MediaMetadataCompat>()

    suspend fun fetchMediaData() = withContext(Dispatchers.IO) {
        state = State.STATE_INITIALIZING
        val playlists = musicDatabase.getAllPlaylists()
        playlists.map { playlist ->

            Builder()
                .putString(METADATA_KEY_ARTIST, playlist.artistName)
                .putString(METADATA_KEY_MEDIA_ID, playlist.mediaId)
                .putString(METADATA_KEY_TITLE, playlist.trackTitle)
                .putString(METADATA_KEY_DISPLAY_TITLE, playlist.trackTitle)
                .putString(METADATA_KEY_DISPLAY_ICON_URI, playlist.artwork)
                .putString(METADATA_KEY_MEDIA_URI, playlist.trackUrl)
                .putString(METADATA_KEY_ALBUM_ART_URI, playlist.artwork)
                .putString(METADATA_KEY_DISPLAY_SUBTITLE, playlist.trackTitle)
                .putString(METADATA_KEY_DISPLAY_DESCRIPTION, playlist.trackTitle)
                .build()
        }
        state = State.STATE_INITIALIZED
    }

    fun asMediaSource(dataSourceFactory: DefaultDataSourceFactory): ConcatenatingMediaSource {
        val concatenatingMediaSource = ConcatenatingMediaSource()
        playlists.forEach { playlists ->
            val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(playlists.getString(METADATA_KEY_MEDIA_URI).toUri())
            concatenatingMediaSource.addMediaSource(mediaSource)
        }
        return concatenatingMediaSource
    }

    fun asMediaItems() = playlists.map { playlist ->
        val desc = MediaDescriptionCompat.Builder()
            .setMediaUri(playlist.getString(METADATA_KEY_MEDIA_URI).toUri())
            .setTitle(playlist.description.title)
            .setSubtitle(playlist.description.subtitle)
            .setMediaId(playlist.description.mediaId)
            .setIconUri(playlist.description.iconUri)
            .build()
        MediaBrowserCompat.MediaItem(desc, FLAG_PLAYABLE)
    }.toMutableList()

    private var state: State = State.STATE_CREATED
        set(value) {
            if (value == State.STATE_INITIALIZED || value == State.STATE_ERROR) {
                field = value
                onReadyListeners.forEach { listener ->
                    listener(state == State.STATE_INITIALIZED)
                }
            } else {
                field = value
            }
        }

    fun whenReady(action: (Boolean) -> Unit): Boolean {
        if (state == State.STATE_CREATED || state == State.STATE_INITIALIZING) {
            onReadyListeners += action
            return false
        } else {
            action(state == State.STATE_INITIALIZED)
            return true
        }
    }
}

enum class State {
    STATE_CREATED,
    STATE_INITIALIZING,
    STATE_INITIALIZED,
    STATE_ERROR
}