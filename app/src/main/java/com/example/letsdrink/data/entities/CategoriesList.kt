package com.example.letsdrink.data.entities

import com.google.gson.annotations.SerializedName

data class CategoriesList(
    @SerializedName("drinks")  val drinks: List<CategoryModel>
)