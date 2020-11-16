package com.example.letsdrink.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.letsdrink.model.CategoryModel

class CategoryViewModel : ViewModel() {
    private val mCategory: MutableLiveData<List<CategoryModel>> = MutableLiveData()

    fun getCategories(): LiveData<List<CategoryModel>> {
        return mCategory
    }
}