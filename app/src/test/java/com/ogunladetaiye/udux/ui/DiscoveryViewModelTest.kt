package com.ogunladetaiye.udux.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.ogunladetaiye.udux.MainCoroutineRule
import com.ogunladetaiye.udux.data.cache.entities.MagicPlaylistEntity
import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.getOrAwaitValueTest
import com.ogunladetaiye.udux.ui.udux_discover.viewmodels.DiscoverViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@ExperimentalCoroutinesApi
class DiscoveryViewModelTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: DiscoverViewModel

    @Inject
    lateinit var uduxApi: UduxApi

    @Before
    fun setup() {
        viewModel = DiscoverViewModel(uduxApi,FakeDiscoveryRepository())
    }


}