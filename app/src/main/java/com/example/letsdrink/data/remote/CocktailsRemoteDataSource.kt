package com.example.letsdrink.data.remote

import javax.inject.Inject

class CocktailsRemoteDataSource @Inject constructor(private val iCocktailApisService: ICocktailApisService) :
    BaseDataSource() {

    suspend fun getAllCategories() = getResult { iCocktailApisService.cocktailsCategory("list") }

    suspend fun getAllAlcoholicOrNonAlcoholicCocktails(alcohol: String) =
        getResult { iCocktailApisService.allAlcoholicAndNonAlcoholicCocktails(alcohol) }

    suspend fun getCocktailDetails(id: Int) = getResult { iCocktailApisService.cocktailDetails(id) }
}