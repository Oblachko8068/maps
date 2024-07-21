package com.example.maps.data.network

import com.example.maps.data.model.AddressResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface DadataApi {

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",
        "Authorization: Token 3bc8f382ebbf65be0a1e125a2a4096646483b000",
        "X-Secret: 6a8650ca7ccbfc1f7ba253ea4d1297257bfbdfa1"
    )
    @POST("v2/clean/address")
    fun requestAddress(@Body request: List<String>): Call<List<AddressResponse>>
}