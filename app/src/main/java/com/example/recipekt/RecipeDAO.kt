package com.example.recipekt

import androidx.room.*


@Dao
interface RecipeDAO {

    @Query("SELECT * FROM tb_recipe")
    fun getAll(): Array<DBRecipe>

    @Query("SELECT * FROM tb_gredient WHERE dishName=:name")
    fun getGredient(name: String): Array<DBGredient>

    @Update
    fun updateRecipe(vararg recipe: DBRecipe)

    @Insert
    fun insertAll(vararg recipe: DBRecipe)

    @Delete
    fun delete(recipe: DBRecipe)
}