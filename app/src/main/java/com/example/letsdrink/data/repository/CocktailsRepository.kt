package com.example.letsdrink.data.repository

import com.example.letsdrink.data.local.CocktailsDao
import com.example.letsdrink.data.remote.CocktailsRemoteDataSource
import com.example.letsdrink.utils.performGetOperation
import javax.inject.Inject

class CocktailsRepository @Inject constructor(
    private val remoteDataSource: CocktailsRemoteDataSource,
    private val localDataSource: CocktailsDao
) {

    fun getCategories() = performGetOperation(
        databaseQuery = { localDataSource.getAllCategories() },
        networkCall = { remoteDataSource.getAllCategories() },
        saveCallResult = { localDataSource.insertAllCategories(it.drinks) }
    )


    fun getDrinks(isAlcohol: Boolean) = performGetOperation(
        databaseQuery = { localDataSource.getAllDrinks(isAlcohol) },
        networkCall = { remoteDataSource.getAllADrinks(isAlcohol) },
        saveCallResult = { it ->
            localDataSource.insertAllDrinks(it.drinks.onEach { it.alcohol = isAlcohol })
        })

    fun getDrinkDetailsById(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getDrinkDetailsById(id) },
        networkCall = { remoteDataSource.getDrinkDetailsById(id) },
        saveCallResult = { localDataSource.insertDrinkDetails(it.drinksDetails) }
    )

    fun getDrinkForCurrentCategory(category: String) = performGetOperation(
        databaseQuery = { localDataSource.getAllDrinksForCurrentCategory(category) },
        networkCall = { remoteDataSource.getDrinksForCurrentCategory(category) },
        saveCallResult = { it ->
            localDataSource.insertAllDrinks(it.drinks.onEach {
                it.category = category
            })
        }
    )
}
