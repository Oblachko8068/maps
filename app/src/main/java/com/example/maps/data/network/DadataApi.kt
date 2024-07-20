package com.example.maps.data.network

import com.example.maps.data.model.AddressRequest
import com.example.maps.data.model.AddressResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface DadataApi {

    @POST("clean/address")
    @Headers("Content-Type: application/json", "Accept: application/json")
    suspend fun cleanAddress(
        @Header("Authorization") token: String,
        @Header("X-Secret") secret: String,
        @Body body: AddressRequest
    ): Response<List<AddressResponse>>

}