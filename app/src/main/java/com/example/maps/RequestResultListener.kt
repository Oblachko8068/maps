package com.example.maps

interface RequestResultListener {

    fun onRequestSuccess(addressInfo: List<String>)

    fun onRequestFailed()
}