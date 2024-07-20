package com.example.maps.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://cleaner.dadata.ru/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}