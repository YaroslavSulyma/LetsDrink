package com.example.letsdrink.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.letsdrink.data.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailsDao {

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Flow<List<CategoryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<CategoryModel>)

    @Query("SELECT * FROM drinks")
    suspend fun getDrinksFromCurrentCategory(): Flow<DrinksModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinksFromCurrentCategory(drinks: List<DrinksModel>)

    @Query("SELECT * FROM drinks")
    fun getAlcoholicCocktails(): Flow<List<DrinksModel>>

    @Query("SELECT * FROM drinks")
    fun getNonAlcoholicCocktails(): Flow<List<DrinksModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDrinks(drinks: List<DrinksModel>)

    @Query("SELECT * FROM details WHERE idDrink = :id")
    fun getDrinkDetailsById(id: Int): Flow<CocktailDetailModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkDetails(drink: CocktailDetailModel)

}