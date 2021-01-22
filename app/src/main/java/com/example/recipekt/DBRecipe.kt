package com.example.recipekt

import androidx.room.*

@Entity(tableName = "tb_recipe")
data class DBRecipe (
    @PrimaryKey var name: String,
    var image: Int?
)

@Entity(tableName = "tb_gredient")
data class DBGredient(
    @PrimaryKey var dishName: String,
    var gredientName: String,
    var gredientAmount: Int,
    var gredientUnit: String
)

data class RecipeWithGredients(
    @Embedded val recipe: DBRecipe,
    @Relation(
        parentColumn = "name",
        entityColumn = "dishName"
    )
    val gredients: List<DBGredient>
)