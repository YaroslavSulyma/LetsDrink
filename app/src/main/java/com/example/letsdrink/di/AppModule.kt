package com.example.letsdrink.di

import android.content.Context
import com.example.letsdrink.data.local.AppDatabase
import com.example.letsdrink.data.local.CocktailsDao
import com.example.letsdrink.data.remote.CocktailsRemoteDataSource
import com.example.letsdrink.utils.Credentials.BASE_URL
import com.example.letsdrink.data.remote.ICocktailApisService
import com.example.letsdrink.data.repository.CocktailsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCocktailService(retrofit: Retrofit): ICocktailApisService = retrofit.create(
        ICocktailApisService::class.java
    )

    @Provides
    @Singleton
    fun provideCocktailsRemoteDataSource(iCocktailApisService: ICocktailApisService) =
        CocktailsRemoteDataSource(iCocktailApisService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCocktailsDao(db: AppDatabase) = db.cocktailsDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: CocktailsRemoteDataSource,
        localDataSource: CocktailsDao
    ) = CocktailsRepository(remoteDataSource, localDataSource)
}