package com.example.letsdrink.data.entities

import com.google.gson.annotations.SerializedName

data class DrinkDetailsList(
    @SerializedName("drinks")
    val drinksDetails: List<DrinkDetailsModel>
)