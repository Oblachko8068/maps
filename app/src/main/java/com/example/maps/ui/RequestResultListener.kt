package com.example.maps.ui

interface RequestResultListener {

    fun onRequestSuccess(addressInfo: List<String>)

    fun onRequestFailed(message: String)
}