package com.example.recipekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var db: AppDatabase? = null
    var recipeList = ArrayList<Recipe>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()


        binding.rvRecipe.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRecipe.setHasFixedSize(true)

        val adapter = RecipeAdapter(recipeList)


        binding.rvRecipe.adapter = adapter

    }

    private fun loadData() {
        db = AppDatabase.getInstance(this)

        val savedData = db!!.RecipeDAO().getAll()
        if (savedData.isNotEmpty()) {
            recipeList.addAll(savedData)
        }
    }
}