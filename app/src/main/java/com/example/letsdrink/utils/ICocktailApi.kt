package com.example.letsdrink.utils

import com.example.letsdrink.response.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ICocktailApi {
    //categories
    //https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list
    @GET("list.php?")
    fun cocktailsCategory(
        @Query("c") c: String
    ): Call<CategoryResponse>
}