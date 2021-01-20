package com.example.recipekt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipekt.databinding.ListGredientsBinding

class GredientsAdapter(val gredientList: ArrayList<Gredient>): RecyclerView.Adapter<GredientsAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ListGredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gredientList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val gredient: Gredient = gredientList[position]
        holder.bind(gredient)
    }

    class CustomViewHolder(val binding: ListGredientsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gredient: Gredient) {
            binding.tvGradient.text = gredient.name
            binding.tvAmount.text = gredient.Amount.toString()
            binding.tvUnit.text = gredient.Unit
        }
    }


}