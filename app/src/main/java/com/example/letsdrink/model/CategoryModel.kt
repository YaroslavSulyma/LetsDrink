package com.example.letsdrink.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    var strCategory: String
) : Parcelable

