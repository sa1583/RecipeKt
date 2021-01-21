package com.example.recipekt

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.recipekt.databinding.ActivityDishDetailBinding
import com.example.recipekt.databinding.ActivityMainBinding

class DishDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDishDetailBinding
    val TAG = "ListActivity"
    var db: AppDatabase? = null
    var gredientList = mutableListOf<Recipe>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDishDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        loadRecipe()

        val dishName = binding.dishName
        var gredients = loadRecipe()

        var data: List<String>
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        binding.spinGredientUnit.adapter = adapter

        binding.spinGredientUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

        }


        binding.btnAddGredient.setOnClickListener {
            val name = binding.etGredientName
            val amount = binding.etGredientAmount
        }


    }

    private fun loadRecipe(): List<Gredient>? {
        db = AppDatabase.getInstance(this)

        val name = binding.dishName.toString()

        val savedRecipe = db!!.RecipeDAO().getRecipe(name)
        return savedRecipe.gredients
    }
}