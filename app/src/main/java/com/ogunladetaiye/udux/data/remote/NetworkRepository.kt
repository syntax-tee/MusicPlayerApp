package com.ogunladetaiye.udux.data.remote

import javax.inject.Inject

class NetworkRepository @Inject constructor(private val uduxApi: UduxApi) {

    suspend fun  retrieveDiscoverScreenAPI() = uduxApi.discoverMusic()

}