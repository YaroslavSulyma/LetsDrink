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
        saveCallResult = { localDataSource.insertAllCategories(it.result) }
    )

    fun getAlcoholicCocktails() = performGetOperation(
        databaseQuery = {localDataSource.getAlcoholicCocktails()},
        networkCall = {remoteDataSource.getAllAlcoholicCocktails()},
        saveCallResult = {localDataSource.insertAllDrinks(it.result)}
    )

    fun getNonAlcoholicCocktails() = performGetOperation(
        databaseQuery = {localDataSource.getNonAlcoholicCocktails()},
        networkCall = {remoteDataSource.getAllNonAlcoholicCocktails()},
        saveCallResult = {localDataSource.insertAllDrinks(it.result)}
    )

    fun getDrinksDetailsById(id:Int) = performGetOperation(
        databaseQuery = {localDataSource.getDrinkDetailsById(id)},
        networkCall = {remoteDataSource.getCocktailDetailsById(id)},
        saveCallResult = {localDataSource.insertDrinkDetails(it)}
    )
}