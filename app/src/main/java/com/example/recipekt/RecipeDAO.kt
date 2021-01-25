package com.example.recipekt

import androidx.room.*


@Dao
interface RecipeDAO {

    @Query("SELECT * FROM tb_recipe")
    fun getAll(): Array<DBRecipe>

    @Query("SELECT * FROM tb_recipe WHERE name=:name")
    fun getRecipe(name: String): DBRecipe

    @Query("SELECT * FROM tb_gredient WHERE dishName=:name")
    fun getGredient(name: String): Array<DBGredient>

    @Update
    fun updateRecipe(vararg recipe: DBRecipe)

    @Insert
    fun insertRecipe(vararg recipe: DBRecipe)

    @Insert
    fun insertGredients(vararg gredients: DBGredient)

    @Delete
    fun deleteRecipe(recipe: DBRecipe)

    @Delete
    fun deleteGredient(gredient: DBGredient)
}