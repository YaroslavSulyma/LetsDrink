package com.example.letsdrink.data.remote

import com.example.letsdrink.data.entities.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICocktailApisService {

    @GET("list.php?")
    suspend fun cocktailsCategory(
        @Query("c") category: String
    ): Response<CategoriesList>

    @GET("filter.php?")
    suspend fun allAlcoholicAndNonAlcoholicCocktails(
        @Query("a") alcohol: String
    ): Response<DrinksList>

    @GET("lookup.php?")
    suspend fun cocktailDetails(
        @Query("i") id: Int
    ): Response<DrinkDetailsList>

    @GET("filter.php?")
    suspend fun cocktailsForCurrentCategory(
        @Query("c") category: String
    ): Response<DrinksList>
}