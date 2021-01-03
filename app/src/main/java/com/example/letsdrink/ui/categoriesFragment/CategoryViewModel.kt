package com.example.letsdrink.ui.categoriesFragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.letsdrink.data.repository.CocktailsRepository

class CategoryViewModel @ViewModelInject constructor(repository: CocktailsRepository) :
    ViewModel() {

    val categories = repository.getCategories()
}