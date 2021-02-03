package com.ogunladetaiye.udux.data.remote

import retrofit2.http.GET

interface UduxApi {


    @GET("screens/discover")
    fun discoverMusic()
}