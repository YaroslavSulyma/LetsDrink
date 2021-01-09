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

    @Query("SELECT * FROM drinks WHERE alcohol =:isAlcohol")
    fun getAllDrinks(isAlcohol: Boolean): LiveData<List<DrinksModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDrinks(drinks: kotlin.collections.List<com.example.letsdrink.data.entities.DrinksModel>)

    /*@Query("SELECT * FROM details WHERE idDrink = :id")
    fun getDrinkDetailsById(id: Int): LiveData<CocktailDetailModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkDetails(drink: CocktailDetailModel)*/

}