package com.example.letsdrink.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinksModel(
    var strDrink: String,
    var strDrinkThumb: String,
    var idDrink: String
) : Parcelable