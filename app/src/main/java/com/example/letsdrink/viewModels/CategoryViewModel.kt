package com.example.letsdrink.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.letsdrink.data.repository.CocktailsRepository

class CategoryViewModel @ViewModelInject constructor(repository: CocktailsRepository) :
    ViewModel() {

    val categories = repository.getCategories().asLiveData()
}