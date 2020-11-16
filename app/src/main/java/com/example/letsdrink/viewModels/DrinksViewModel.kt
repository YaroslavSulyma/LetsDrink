package com.example.letsdrink.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.letsdrink.model.DrinksModel

class DrinksViewModel : ViewModel() {
    private val mDrinks: MutableLiveData<List<DrinksModel>> = MutableLiveData()

    fun getDrinks(): LiveData<List<DrinksModel>> {
        return mDrinks
    }
}