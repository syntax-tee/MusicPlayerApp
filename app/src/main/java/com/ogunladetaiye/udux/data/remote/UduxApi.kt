package com.ogunladetaiye.udux.data.remote

import com.ogunladetaiye.udux.data.remote.response.UduxModelResponse
import retrofit2.http.GET

interface UduxApi {


    @GET("screens/discover")
    fun discoverMusic(): UduxModelResponse
}