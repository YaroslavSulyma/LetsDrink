package com.example.letsdrink.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "drinks")
data class DrinksModel(
    var strDrink: String,
    var strDrinkThumb: String,
    @PrimaryKey
    var idDrink: String
) : Parcelable