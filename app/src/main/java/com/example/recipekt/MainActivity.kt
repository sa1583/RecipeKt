package com.example.recipekt

import android.content.Intent
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

        binding.fabPlus.setOnClickListener {
            val intent = Intent(this, DishDetailActivity::class.java)
            intent.putExtra("isNew", 1)
            startActivity(intent)
        }

    }

    private fun loadData() {
        db = AppDatabase.getInstance(this)

        val recipeDB = db!!.RecipeDAO().getAll()
        if (recipeDB.isNotEmpty()) {
            for (rip in recipeDB) {
                recipeList.add(Recipe(null, rip.name, null))
            }
        }
        else {
            val gredients = ArrayList<Gredient>()
            gredients.add(Gredient("면", 300, "g"))
            val recipe = Recipe(null, "쫄면", gredients)
            recipeList.add(recipe)
        }
    }
}