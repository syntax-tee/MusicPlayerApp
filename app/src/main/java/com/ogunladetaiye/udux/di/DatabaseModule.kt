package com.ogunladetaiye.udux.di

import android.content.Context
import androidx.room.Room
import com.ogunladetaiye.udux.data.cache.UduxDatabase
import com.ogunladetaiye.udux.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
            @ApplicationContext context: Context
    ) = Room.databaseBuilder(
            context,
            UduxDatabase::class.java,
            DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: UduxDatabase) = database.uduxDao()


}