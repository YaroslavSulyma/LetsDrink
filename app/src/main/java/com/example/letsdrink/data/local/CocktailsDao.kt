package com.example.letsdrink.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.letsdrink.data.entities.*

@Dao
interface CocktailsDao {

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<CategoryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<CategoryModel>)

    @Query("SELECT * FROM drinks WHERE alcohol =:isAlcohol AND alcohol NOT null")
    fun getAllDrinks(isAlcohol: Boolean): LiveData<List<DrinksModel>>

    @Query("SELECT * FROM drinks WHERE category =:category")
    fun getAllDrinksForCurrentCategory(category: String): LiveData<List<DrinksModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDrinks(drinks: List<DrinksModel>)

    @Query("SELECT * FROM details WHERE idDrink = :id")
    fun getDrinkDetailsById(id: Int): LiveData<DrinkDetailsModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkDetails(drink: List<DrinkDetailsModel>)

}