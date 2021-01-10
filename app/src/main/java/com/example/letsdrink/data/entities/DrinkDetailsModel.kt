package com.example.letsdrink.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "details")
data class DrinkDetailsModel(
    @PrimaryKey
    @SerializedName("idDrink") val idDrink: Int,
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strCategory") val strCategory: String,
    @SerializedName("strTags") val strTags: String?,
    @SerializedName("strAlcoholic") val strAlcoholic: String,
    @SerializedName("strGlass") val strGlass: String,
    @SerializedName("strInstructions") val strInstructions: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String?,
    @SerializedName("strIngredient1") val strIngredient1: String?,
    @SerializedName("strIngredient2") val strIngredient2: String?,
    @SerializedName("strIngredient3") val strIngredient3: String?,
    @SerializedName("strIngredient4") val strIngredient4: String?,
    @SerializedName("strIngredient5") val strIngredient5: String?,
    @SerializedName("strMeasure1") val strMeasure1: String?,
    @SerializedName("strMeasure2") val strMeasure2: String?,
    @SerializedName("strMeasure3") val strMeasure3: String?,
    @SerializedName("strMeasure4") val strMeasure4: String?,
    @SerializedName("strMeasure5") val strMeasure5: String?,
)