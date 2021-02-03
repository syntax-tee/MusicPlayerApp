package com.ogunladetaiye.udux.data.remote.response


import com.google.gson.annotations.SerializedName

data class Undefined(
    @SerializedName("_nanoseconds")
    val nanoseconds: Int,
    @SerializedName("_seconds")
    val seconds: Int
)