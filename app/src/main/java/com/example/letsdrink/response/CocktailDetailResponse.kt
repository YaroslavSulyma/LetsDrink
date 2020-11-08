package com.example.letsdrink.response

import com.example.letsdrink.model.DrinksModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailDetailResponse(
    @SerializedName("drinks")
    @Expose()
    private var detail: DrinksModel

) {
    override fun toString(): String {
        return "CocktailDetailResponse(detail=$detail)"
    }
}