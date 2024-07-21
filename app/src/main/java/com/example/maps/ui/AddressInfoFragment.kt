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

class AddressInfoFragment : Fragment() {

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
        val addressInfo = arguments?.getStringArrayList(ARG_ADDRESS_INFO)?.toList() ?: emptyList()
        setUpRecyclerAdapter(addressInfo)
        binding.btnOpenMap.setOnClickListener {
            openMap(addressInfo[0])
        }
    }

    private fun setUpRecyclerAdapter(addressInfo: List<String>) {
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

    companion object {

        private const val ARG_ADDRESS_INFO = "address_info"

        fun newInstance(addressInfo: List<String>): AddressInfoFragment {
            return AddressInfoFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_ADDRESS_INFO, ArrayList(addressInfo))
                }
            }
        }
    }
}