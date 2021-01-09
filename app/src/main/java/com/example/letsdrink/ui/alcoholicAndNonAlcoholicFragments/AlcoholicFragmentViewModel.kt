package com.example.letsdrink.ui.alcoholicAndNonAlcoholicFragments

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.letsdrink.data.repository.CocktailsRepository

class AlcoholicFragmentViewModel @ViewModelInject constructor(repository: CocktailsRepository) :
    ViewModel() {
    val drinks = repository.getDrinks(true)
}