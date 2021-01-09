package com.example.letsdrink.ui.alcoholicAndNonAlcoholicFragments

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.letsdrink.data.entities.DrinksModel
import com.example.letsdrink.data.repository.CocktailsRepository

class NonAlcoholicFragmentViewModel @ViewModelInject constructor(repository: CocktailsRepository) :
    ViewModel() {
    val drinks = repository.getDrinks(false)
}