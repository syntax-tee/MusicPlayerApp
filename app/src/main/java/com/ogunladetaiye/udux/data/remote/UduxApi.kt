package com.ogunladetaiye.udux.data.remote

import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponse
import retrofit2.http.GET

interface UduxApi {

    @GET("screens/discover")
    suspend fun discoverMusic(): DiscoverApiResponse
}