package com.example.recipekt

import android.view.LayoutInflater
import android.view.ViewGroup
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
    }

    fun update(newGredients: List<Gredient>) {
        val diffResult = DiffUtil.calculateDiff(ContentDiffUtil(gredientList, newGredients), false)
        diffResult.dispatchUpdatesTo(this)
        gredientList.clear()
        gredientList.addAll(newGredients)
    }

    class CustomViewHolder(val binding: ListGredientsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gredient: Gredient) {
            binding.tvGradient.text = gredient.name
            binding.tvAmount.text = gredient.Amount.toString()
            binding.tvUnit.text = gredient.Unit
        }
    }
}

class ContentDiffUtil(private val oldList: List<Gredient>, private val curList: List<Gredient>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == curList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == curList[newItemPosition]
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = curList.size


}