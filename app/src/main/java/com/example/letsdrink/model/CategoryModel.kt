package com.example.letsdrink.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    private var strCategory: String
) : Parcelable

