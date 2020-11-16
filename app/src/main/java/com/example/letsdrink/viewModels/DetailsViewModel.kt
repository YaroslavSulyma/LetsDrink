package com.example.letsdrink.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.letsdrink.model.CocktailDetailModel

class DetailsViewModel : ViewModel() {
    private val mDetails: MutableLiveData<CocktailDetailModel> = MutableLiveData()

    fun getDetails(): MutableLiveData<CocktailDetailModel> {
        return mDetails
    }
}