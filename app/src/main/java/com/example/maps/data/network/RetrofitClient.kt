package com.example.maps.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dadata.ru/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: DadataApi = retrofit.create(DadataApi::class.java)
}