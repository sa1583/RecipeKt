package com.example.recipekt

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipekt.databinding.ListGredientsBinding

class GredientsAdapter : RecyclerView.Adapter<GredientsAdapter.CustomViewHolder>() {

    private val gredientList = mutableListOf<Gredient>()

    val gredients: List<Gredient>
        get() = gredientList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ListGredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount() = gredientList.size


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val gredient: Gredient = gredientList[position]
        holder.bind(gredient)
        holder.itemView.setOnClickListener {
            val deleteItem = gredientList.find {
                gredient.name == it.name
            }
            gredientList.remove(deleteItem)
            notifyDataSetChanged()
        }
    }

    fun update(newGredients: List<Gredient>) {
        gredientList.clear()
        gredientList.addAll(newGredients)
        notifyDataSetChanged()
    }

    class CustomViewHolder(val binding: ListGredientsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gredient: Gredient) {
            binding.tvGradient.text = gredient.name
            binding.tvAmount.text = gredient.Amount.toString()
            binding.tvUnit.text = gredient.Unit
        }
    }
}

