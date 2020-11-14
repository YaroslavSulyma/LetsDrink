package com.example.letsdrink.utils

import com.example.letsdrink.model.CocktailDetailModel
import com.example.letsdrink.response.CategoryResponse
import com.example.letsdrink.response.CocktailDetailResponse
import com.example.letsdrink.response.DrinksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ICocktailApi {
    //categories
    //https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list
    @GET("list.php?")
    fun cocktailsCategory(
        @Query("c") category: String
    ): Call<CategoryResponse>

    //cocktail list
    //https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
    @GET("filter.php?")
    fun allAlcoholicAndNonAlcoholicCocktails(
        @Query("a") alcohol: String
    ): Call<DrinksResponse>

    //cocktail detail by id
    //https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007
    @GET("lookup.php?")
    fun cocktailDetails(
        @Query("i") id: String
    ): Call<CocktailDetailResponse>
}