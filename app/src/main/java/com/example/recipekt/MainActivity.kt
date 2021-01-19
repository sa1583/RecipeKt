package com.example.recipekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeList = arrayListOf(
                Recipes(R.drawable.dish, "볶음밥"),
                Recipes(R.drawable.dish, "수육"),
                Recipes(R.drawable.dish, "파채"),
                Recipes(R.drawable.dish, "몽골리안 비프"),
                Recipes(R.drawable.dish, "123")

        )
        binding.rvRecipe.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRecipe.setHasFixedSize(true)

        binding.rvRecipe.adapter = RecipeAdapter(recipeList)

    }
}