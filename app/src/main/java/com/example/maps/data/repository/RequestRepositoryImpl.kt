package com.example.maps.data.repository

import com.example.maps.data.model.AddressResponse
import com.example.maps.data.network.RetrofitClient
import com.example.maps.ui.MainFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestRepositoryImpl {

    fun makeRequest(inputText: String, mainFragment: MainFragment) {
        val requestCallback = object : Callback<List<AddressResponse>> {
            override fun onResponse(
                call: Call<List<AddressResponse>>,
                response: Response<List<AddressResponse>>
            ) {
                if (response.isSuccessful) {
                    val addressResponses = response.body()
                    if (addressResponses != null) {
                        val addressInfo = AddressInfoFormatter.toAddressInfo(addressResponses[0])
                        mainFragment.onRequestSuccess(addressInfo)
                    } else {
                        mainFragment.onRequestFailed("Адрес не найден")
                    }
                } else {
                    mainFragment.onRequestFailed("Ошибка поиска")
                }
            }

            override fun onFailure(call: Call<List<AddressResponse>>, t: Throwable) {
                mainFragment.onRequestFailed("Ошибка запроса")
            }
        }

        RetrofitClient.api.requestAddress(listOf(inputText)).enqueue(requestCallback)
    }
}