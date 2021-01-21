package com.example.recipekt

import androidx.room.*

@Entity(tableName = "tb_recipe")
data class DBRecipe (
    @PrimaryKey(autoGenerate = true) val id: Int,
    var name: String,
    var image: Int?,
    var gredients: List<Gredient>?
){



}