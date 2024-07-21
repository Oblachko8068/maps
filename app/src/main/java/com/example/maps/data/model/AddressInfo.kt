package com.example.maps.data.model

data class AddressInfo(
    val result: String,
    val postal_code: String?,
    val country: String?,
    val federal_district: String?,
    val region: String?,
    val area: String?,
    val city: String?,
    val city_district: String?,
    val settlement: String?,
    val street: String?,
    val flat: String?,
    val entrance: String?,
    val floor: String?,
    val flat_area: String?,
    val flat_price: String?,
    val fias_actuality_state: String?,
    val geo_lat: String?,
    val geo_lon: String?,
    val metro: List<Metro>?
)