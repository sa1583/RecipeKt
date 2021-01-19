package com.example.recipekt

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(val recipeList: ArrayList<Recipes>): RecyclerView.Adapter<RecipeAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_recipe, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val intent = Intent(this, )
            }

        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeAdapter.CustomViewHolder, position: Int) {
        holder.image.setImageResource(recipeList.get(position).image)
        holder.name.text = recipeList.get(position).name
    }

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.iv_image)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
    }

}