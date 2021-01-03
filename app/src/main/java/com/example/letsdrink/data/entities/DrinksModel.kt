package com.example.letsdrink.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "drinks")
data class DrinksModel(
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String?,
    @PrimaryKey
    @SerializedName("idDrink") val idDrink: Int
)