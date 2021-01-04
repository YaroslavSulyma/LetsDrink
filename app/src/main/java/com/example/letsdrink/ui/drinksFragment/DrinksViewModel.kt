package com.example.letsdrink.ui.drinksFragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.letsdrink.data.repository.CocktailsRepository

class DrinksViewModel @ViewModelInject constructor(repository: CocktailsRepository) : ViewModel() {

}