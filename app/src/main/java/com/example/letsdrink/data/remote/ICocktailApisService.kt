package com.example.letsdrink.data.remote

import com.example.letsdrink.data.entities.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICocktailApisService {
    //categories
    //https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list
    @GET("list.php?")
    suspend fun cocktailsCategory(
        @Query("c") category: String
    ): Response<CategoriesList>

    //cocktail list
    //https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
    @GET("filter.php?")
    suspend fun allAlcoholicAndNonAlcoholicCocktails(
        @Query("a") alcohol: String
    ): Response<DrinksList>
/*
    //cocktail detail by id
    //https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007
    @GET("lookup.php?")
    suspend fun cocktailDetails(
        @Query("i") id: Int
    ): Response<CocktailDetailModel>*/
}