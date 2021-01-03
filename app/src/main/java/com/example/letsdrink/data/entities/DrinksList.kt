package com.example.letsdrink.data.entities

import com.google.gson.annotations.SerializedName

data class DrinksList(
    @SerializedName("drinks") val drinks: List<DrinksModel>
)
