package com.example.maps.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maps.R
import com.example.maps.databinding.FragmentAddressInfoBinding

class AddressInfoFragment(private val addressInfo: List<String>) : Fragment() {

    private var _binding: FragmentAddressInfoBinding? = null
    private val binding get() = _binding!!
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerAdapter()
        val address = "г Москва, ул Сухонская"
        binding.btnOpenMap.setOnClickListener {
            openMap(address)
        }
    }

    private fun setUpRecyclerAdapter() {
        val infoNamesList = resources.getStringArray(R.array.info_names_array).toList()
        recyclerView = binding.recyclerView
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = InfoRecyclerAdapter(
            addressInfo, infoNamesList
        )
    }

    private fun openMap(address: String) {
        val gmmIntentUri = Uri.parse("geo:0,0?q=$address")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}