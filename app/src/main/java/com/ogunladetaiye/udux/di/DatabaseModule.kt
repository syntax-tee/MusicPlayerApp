package com.ogunladetaiye.udux.di

import android.content.Context
import androidx.room.Room
import com.ogunladetaiye.udux.data.cache.CacheRepository
import com.ogunladetaiye.udux.data.cache.DiscoveryRepository
import com.ogunladetaiye.udux.data.cache.UduxDao
import com.ogunladetaiye.udux.data.cache.UduxDatabase
import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        UduxDatabase::class.java,
        DATABASE_NAME
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(database: UduxDatabase) = database.uduxDao()


    @Singleton
    @Provides
    fun provideDiscoveryRepository(
        dao: UduxDao,
    ) = CacheRepository(dao) as DiscoveryRepository


}