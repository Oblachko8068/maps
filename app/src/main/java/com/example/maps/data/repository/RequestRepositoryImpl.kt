package com.example.maps.data.repository

import com.example.maps.data.model.AddressRequest
import com.example.maps.data.network.DadataApi
import com.example.maps.data.network.RetrofitClient

class RequestRepositoryImpl {

    suspend fun makeRequest(inputText: String) {
        val api = RetrofitClient.instance.create(DadataApi::class.java)
        val token = "3bc8f382ebbf65be0a1e125a2a4096646483b000"
        val secret = "6a8650ca7ccbfc1f7ba253ea4d1297257bfbdfa1"
        val addressRequest = AddressRequest(listOf(inputText))
        val response = api.cleanAddress(token, secret, addressRequest)
        if (response.isSuccessful) {
            if (response.body() != null) {
                val list = response.body()
                val p = 0
            }
        }
    }
}