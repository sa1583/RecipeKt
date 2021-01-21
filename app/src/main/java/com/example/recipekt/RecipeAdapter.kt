package com.example.recipekt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipekt.databinding.ActivityDishDetailBinding

class RecipeAdapter(val recipeList: ArrayList<Recipe>): RecyclerView.Adapter<RecipeAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ActivityDishDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int  = recipeList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.bind(recipe)
    }

    class CustomViewHolder(val binding: ActivityDishDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(recipe: Recipe) {
            if (recipe.image == null)
                binding.dishImage.setImageResource(R.drawable.dish)
            else
                binding.dishImage.setImageResource(recipe.image)
            binding.dishName.text = recipe.name
        }
    }


}