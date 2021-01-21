package com.example.recipekt

import androidx.room.*


@Dao
interface RecipeDAO {
    @Query("SELECT * FROM tb_recipe")
    fun getAll(): List<Recipe>

    @Query("SELECT * FROM tb_recipe WHERE name=:name")
    fun getRecipe(name: String): Recipe

    @Update
    fun updateRecipe(vararg recipe: Recipe)

    @Insert
    fun insertAll(vararg recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}