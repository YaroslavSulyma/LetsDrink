package com.example.letsdrink.ui.drinksFragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.letsdrink.data.entities.DrinksModel
import com.example.letsdrink.data.repository.CocktailsRepository
import com.example.letsdrink.utils.Resource

class DrinksViewModel @ViewModelInject constructor(repository: CocktailsRepository) : ViewModel() {

    private val _category = MutableLiveData<String>()
    private val _drinks = _category.switchMap { category ->
        repository.getDrinkForCurrentCategory(category)
    }

    val drinks: LiveData<Resource<List<DrinksModel>>> = _drinks

    fun start(category: String) {
        _category.value = category
    }

}