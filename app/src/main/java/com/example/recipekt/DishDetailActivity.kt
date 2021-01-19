package com.example.recipekt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipekt.databinding.ActivityMainBinding

class DishDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()


    }

    private fun loadData() {

    }

    fun saveData() {
        val pref = getSharedPreferences("dish", 0)
        val edit = pref.edit()
        val key = binding.
        edit.putString()
    }
}