package com.example.recipekt

import androidx.room.*

@Entity(tableName = "tb_recipe")
data class DBRecipe (
    @PrimaryKey var name: String,
    var image: String?
)

@Entity(tableName = "tb_gredient", primaryKeys = ["dishName", "gredientName"])
data class DBGredient(
        val dishName: String,
        val gredientName: String,
        val gredientAmount: Int,
        val gredientUnit: String
)

data class RecipeWithGredients(
    @Embedded val recipe: DBRecipe,
    @Relation(
        parentColumn = "name",
        entityColumn = "dishName"
    )
    val gredients: List<DBGredient>
)