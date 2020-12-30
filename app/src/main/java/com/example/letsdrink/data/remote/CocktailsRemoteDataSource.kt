package com.example.letsdrink.data.remote

import javax.inject.Inject

class CocktailsRemoteDataSource @Inject constructor(private val iCocktailApisService: ICocktailApisService) :
    BaseDataSource() {

    suspend fun getAllCategories() = getResult { iCocktailApisService.cocktailsCategory("list") }

    suspend fun getAllAlcoholicCocktails() =
        getResult { iCocktailApisService.allAlcoholicAndNonAlcoholicCocktails("Alcoholic") }

    suspend fun getAllNonAlcoholicCocktails() =
        getResult { iCocktailApisService.allAlcoholicAndNonAlcoholicCocktails("Non_Alcoholic") }

    suspend fun getCocktailDetailsById(id: Int) = getResult { iCocktailApisService.cocktailDetails(id) }
}