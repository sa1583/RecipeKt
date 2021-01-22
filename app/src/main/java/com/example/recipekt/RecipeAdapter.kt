package com.example.recipekt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipekt.databinding.ActivityDishDetailBinding
import com.example.recipekt.databinding.ActivityMainBinding
import com.example.recipekt.databinding.ListRecipeBinding

class RecipeAdapter(val recipeList: ArrayList<Recipe>): RecyclerView.Adapter<RecipeAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ListRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int  = recipeList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.bind(recipe)
    }

    class CustomViewHolder(val binding: ListRecipeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(recipe: Recipe) {
            if (recipe.image == null)
                binding.ivImage.setImageResource(R.drawable.dish)
            else
                binding.ivImage.setImageResource(recipe.image)
            binding.tvName.text = recipe.name
        }
    }


}