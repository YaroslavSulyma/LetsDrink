package com.example.letsdrink.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.letsdrink.data.entities.CategoryModel
import com.example.letsdrink.data.entities.CocktailDetailModel
import com.example.letsdrink.data.entities.DrinksModel

@Database(
    entities = [CategoryModel::class, DrinksModel::class/*, CocktailDetailModel::class*/],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cocktailsDao(): CocktailsDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "cocktails")
                .fallbackToDestructiveMigration()
                .build()
    }
}
