package com.example.letsdrink.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "categories")
data class CategoryModel(
    var strCategory: String,
    var strthumb: String
) : Parcelable

