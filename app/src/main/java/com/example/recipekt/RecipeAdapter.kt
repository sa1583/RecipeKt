package com.example.recipekt

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipekt.databinding.ActivityDishDetailBinding

class RecipeAdapter(val recipeList: ArrayList<Recipes>): RecyclerView.Adapter<RecipeAdapter.CustomViewHolder>() {

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
        fun bind(recipe: Recipes) {
            binding.dishImage.setImageResource(recipe.image)
            binding.dishName.text = recipe.name
        }
    }


}