package com.ogunladetaiye.udux.data.cache.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.ogunladetaiye.udux.data.cache.firebase.entities.Playlist
import com.ogunladetaiye.udux.utils.Constants.PLAYLIST_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()

    private val playlistCollection = firestore.collection(PLAYLIST_COLLECTION)

    suspend fun getAllPlaylists(): List<Playlist> {
        return try {
            playlistCollection.get().await().toObjects(Playlist::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}