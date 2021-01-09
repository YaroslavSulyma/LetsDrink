package com.example.letsdrink.data.remote

import com.example.letsdrink.data.entities.DrinksList
import com.example.letsdrink.utils.Resource
import javax.inject.Inject

class CocktailsRemoteDataSource @Inject constructor(private val iCocktailApisService: ICocktailApisService) :
    BaseDataSource() {

    suspend fun getAllCategories() = getResult { iCocktailApisService.cocktailsCategory("list") }

    suspend fun getAllADrinks(isAlcohol: Boolean): Resource<DrinksList> {
        return if (isAlcohol) {
            getResult { iCocktailApisService.allAlcoholicAndNonAlcoholicCocktails("Alcoholic") }
        } else getResult { iCocktailApisService.allAlcoholicAndNonAlcoholicCocktails("Non_Alcoholic") }
    }


    /* suspend fun getDrinksForCurrentCategory(category:String) = getResult { iCocktailApisService.cocktailsCategory(category) }*/


    /* suspend fun getCocktailDetailsById(id: Int) = getResult { iCocktailApisService.cocktailDetails(id) }*/
}