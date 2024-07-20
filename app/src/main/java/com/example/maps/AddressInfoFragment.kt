package com.example.maps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maps.databinding.FragmentAddressInfoBinding

class AddressInfoFragment : Fragment() {

    private var _binding: FragmentAddressInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val latitude = 55.8783089
        val longtitute = 37.6537862
        binding.btnOpenMap.setOnClickListener {
            openMap(latitude, longtitute)
        }
    }

    private fun openMap(latitude: Double, longtitute: Double) {
        val gmmIntentUri = Uri.parse("geo:$latitude,$longtitute")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}