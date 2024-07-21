package com.example.maps.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.maps.R
import com.example.maps.RequestResultListener
import com.example.maps.data.repository.RequestRepositoryImpl
import com.example.maps.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment(), RequestResultListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submit.setOnClickListener {
            val inputText = binding.searchText.text.toString()
            if (inputText != "") {
                val requestRepositoryImpl = RequestRepositoryImpl()
                viewLifecycleOwner.lifecycleScope.launch {
                    requestRepositoryImpl.makeRequest("мск сухонска 11/-89", this@MainFragment)
                }
            } else {
                Toast.makeText(requireContext(), "Введите адрес", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onRequestSuccess(addressInfo: List<String>) {
        parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, AddressInfoFragment(addressInfo))
            .commit()
    }

    override fun onRequestFailed() {
        Toast.makeText(requireContext(), "Адрес не найден", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}