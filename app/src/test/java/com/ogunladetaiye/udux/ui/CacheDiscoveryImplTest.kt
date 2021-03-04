package com.ogunladetaiye.udux.ui

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ogunladetaiye.entity.DummyData
import com.ogunladetaiye.udux.data.cache.CacheRepository
import com.ogunladetaiye.udux.data.cache.DiscoveryRepository
import com.ogunladetaiye.udux.data.cache.UduxDatabase
import com.ogunladetaiye.udux.data.cache.entities.MagicPlaylistEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CacheDiscoveryImplTest {


    private lateinit var discoveryRepository: DiscoveryRepository
    private lateinit var uduxDatabase: UduxDatabase
    @Before
    fun setup() {
        uduxDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UduxDatabase::class.java
        ).allowMainThreadQueries().build()

        discoveryRepository = CacheRepository(
            uduxDatabase.uduxDao(),
        )
    }

    @Test
    fun `check that magicPlaylistEntity inserts data into database`() = runBlocking {
        val magicPlaylistEntity: MagicPlaylistEntity = DummyData.magicPlaylistEntity

    }


    @After
    fun tearDown(){
        uduxDatabase.close()
    }

}