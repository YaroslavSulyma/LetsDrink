package com.example.letsdrink.di

import com.example.letsdrink.utils.Credentials.BASE_URL
import com.example.letsdrink.data.remote.ICocktailApisService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
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
    fun providePokemonService(retrofit: Retrofit): ICocktailApisService = retrofit.create(
        ICocktailApisService::class.java)
}