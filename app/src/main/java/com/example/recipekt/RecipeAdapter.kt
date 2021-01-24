package com.example.recipekt

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
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
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DishDetailActivity::class.java)
            intent.putExtra("isNew", 0)
            intent.putExtra("dishName", recipe.name)
            intent.putExtra("dishImage", recipe.image)
            startActivity(holder.itemView.context, intent, null)
        }
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