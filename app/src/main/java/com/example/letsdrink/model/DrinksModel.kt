package com.example.letsdrink.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinksModel(
    private var strDrink: String,
    private var strDrinkThumb: String,
    private var idDrink: String
) : Parcelable