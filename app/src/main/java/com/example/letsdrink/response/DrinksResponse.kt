package com.example.letsdrink.response

import com.example.letsdrink.model.DrinksModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DrinksResponse(
    @SerializedName("drinks")
    @Expose()
    private var drinks: List<DrinksModel>

) {
    override fun toString(): String {
        return "DrinksResponse(drinks=$drinks)"
    }
}