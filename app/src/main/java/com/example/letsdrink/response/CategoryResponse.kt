package com.example.letsdrink.response

import com.example.letsdrink.model.CategoryModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("drinks")
    @Expose()
    var categories: List<CategoryModel>

) {
    override fun toString(): String {
        return "CategoryResponse(categories=$categories)"
    }
}
