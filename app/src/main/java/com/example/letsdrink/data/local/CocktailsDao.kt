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
    fun getAllCategories(): Flow<CategoryListModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<CategoryModel>)

    @Query("SELECT * FROM drinks")
    fun getAlcoholicCocktails(): Flow<DrinksListModel>

    @Query("SELECT * FROM drinks")
    fun getNonAlcoholicCocktails(): Flow<DrinksListModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDrinks(drinks: List<DrinksModel>)

    @Query("SELECT * FROM details WHERE idDrink = :id")
    fun getDrinkDetailsById(id: Int): Flow<CocktailDetailModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkDetails(drink: CocktailDetailModel)

}