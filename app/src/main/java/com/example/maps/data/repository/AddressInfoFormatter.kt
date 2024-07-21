package com.example.maps.data.repository

import com.example.maps.data.model.AddressResponse
import com.example.maps.data.model.Metro

class AddressInfoFormatter {

    companion object {
        fun toAddressInfo(addressResponse: AddressResponse): List<String> {
            val addressInfoList = mutableListOf<String>()
            with(addressInfoList) {
                add(addressResponse.result)
                add(addressResponse.postal_code ?: "-")
                add(addressResponse.country ?: "-")
                add(addressResponse.federal_district ?: "-")
                add(addressResponse.region ?: "-")
                add(addressResponse.area ?: "-")
                add(addressResponse.city ?: "-")
                add(addressResponse.city_district ?: "-")
                add(addressResponse.settlement ?: "-")
                add(addressResponse.street ?: "-")
                add(addressResponse.house ?: "-")
                add(addressResponse.flat ?: "-")
                add(addressResponse.entrance ?: "-")
                add(addressResponse.floor ?: "-")
                add(addressResponse.flat_area ?: "-")
                add(addressResponse.flat_price ?: "-")
                add(getActualityText(addressResponse.fias_actuality_state))
                add(addressResponse.geo_lat ?: "-")
                add(addressResponse.geo_lon ?: "-")
                add(getMetroText(addressResponse.metro))
            }
            return addressInfoList
        }

        private fun getMetroText(metro: List<Metro>?): String {
            return metro?.joinToString(separator = "\n") { metroStation ->
                "${metroStation.name} (${metroStation.line}, ${metroStation.distance} км)"
            } ?: "-"
        }

        private fun getActualityText(fiasActualityState: String?): String {
            return when (fiasActualityState?.toIntOrNull()) {
                0 -> "актуальный"
                in 1..50 -> "переименован"
                51 -> "переподчинен"
                99 -> "удален"
                else -> "-"
            }
        }
    }
}