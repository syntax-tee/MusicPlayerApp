package com.ogunladetaiye.udux.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ogunladetaiye.udux.data.cache.entities.Utilities

interface UduxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUtilities(utilities: Utilities)

    @Query("SELECT * from ")
    fun observeUtilities(): LiveData<List<Utilities>>


}