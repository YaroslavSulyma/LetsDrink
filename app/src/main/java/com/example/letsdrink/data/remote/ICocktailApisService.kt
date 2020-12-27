package com.example.letsdrink.data.remote

import com.example.letsdrink.data.entities.CategoryListModel
import com.example.letsdrink.data.entities.CocktailDetailModel
import com.example.letsdrink.data.entities.DrinksListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICocktailApisService {
    //categories
    //https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list
    @GET("list.php?")
    fun cocktailsCategory(
        @Query("c") category: String
    ): Response<CategoryListModel>

    //cocktail list
    //https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
    @GET("filter.php?")
    fun allAlcoholicAndNonAlcoholicCocktails(
        @Query("a") alcohol: String
    ): Response<DrinksListModel>

    //cocktail detail by id
    //https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007
    @GET("lookup.php?")
    fun cocktailDetails(
        @Query("i") id: Int
    ): Response<CocktailDetailModel>
}