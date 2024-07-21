package com.example.maps.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maps.databinding.InfoBlockBinding

class InfoRecyclerAdapter(
    private val infoList: List<String?>,
    private val infoNameList: List<String>
) : RecyclerView.Adapter<InfoRecyclerAdapter.InfoViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InfoViewHolder {
        val binding = InfoBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InfoViewHolder(binding)
    }

    class InfoViewHolder(val binding: InfoBlockBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val name = infoNameList[position]
        val desc = infoList[position]
        holder.binding.name.text = name
        holder.binding.description.text = desc ?: "-"
    }

    override fun getItemCount(): Int = infoNameList.size

}