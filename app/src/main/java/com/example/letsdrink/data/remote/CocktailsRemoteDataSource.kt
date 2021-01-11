package com.example.letsdrink.data.remote


import com.example.letsdrink.data.entities.DrinksList
import com.example.letsdrink.utils.Resource
import javax.inject.Inject

class CocktailsRemoteDataSource @Inject constructor(private val iCocktailApiService: ICocktailApisService) :
    BaseDataSource() {

    suspend fun getAllCategories() = getResult { iCocktailApiService.cocktailsCategory("list") }

    suspend fun getAllADrinks(isAlcohol: Boolean): Resource<DrinksList> {
        return if (isAlcohol) {
            getResult { iCocktailApiService.allAlcoholicAndNonAlcoholicCocktails("Alcoholic") }
        } else getResult { iCocktailApiService.allAlcoholicAndNonAlcoholicCocktails("Non_Alcoholic") }
    }

    suspend fun getDrinkDetailsById(id: Int) = getResult { iCocktailApiService.cocktailDetails(id) }

    suspend fun getDrinksForCurrentCategory(category: String) =
        getResult { iCocktailApiService.cocktailsForCurrentCategory(category) }

}