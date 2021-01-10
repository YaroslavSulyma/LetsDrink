package com.example.letsdrink.ui.detailsFragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.letsdrink.data.entities.DrinkDetailsModel
import com.example.letsdrink.data.repository.CocktailsRepository
import com.example.letsdrink.utils.Resource

class DetailsViewModel @ViewModelInject constructor(repository: CocktailsRepository) : ViewModel() {

    private val _id = MutableLiveData<Int>()
    private val _details = _id.switchMap { id ->
        repository.getDrinkDetailsById(id)
    }

    val details: LiveData<Resource<DrinkDetailsModel>> = _details

    fun start(id: Int) {
        _id.value = id
    }
}