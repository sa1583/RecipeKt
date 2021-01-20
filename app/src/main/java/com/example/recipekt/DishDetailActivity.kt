package com.example.recipekt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipekt.databinding.ActivityDishDetailBinding
import com.example.recipekt.databinding.ActivityMainBinding

class DishDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDishDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDishDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        binding.btnModify.setOnClickListener {

        }


    }

    private fun loadData() {

    }
}