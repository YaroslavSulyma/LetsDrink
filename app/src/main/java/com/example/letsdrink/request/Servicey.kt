package com.example.letsdrink.request

import com.example.letsdrink.utils.Credentials.BASE_URL
import com.example.letsdrink.utils.ICocktailApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Servicey {

    private val retrofitBuilder: Retrofit.Builder =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())

    private val retrofit = retrofitBuilder.build()

    private val cocktailApi: ICocktailApi = retrofit.create(ICocktailApi::class.java)

    fun getCocktailApi(): ICocktailApi {
        return cocktailApi
    }

}