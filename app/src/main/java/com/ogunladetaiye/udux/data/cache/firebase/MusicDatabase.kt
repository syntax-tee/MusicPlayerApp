package com.ogunladetaiye.udux.data.cache.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.ogunladetaiye.udux.data.cache.firebase.entities.Song
import com.ogunladetaiye.udux.utils.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch(e: Exception) {
            emptyList()
        }
    }
}