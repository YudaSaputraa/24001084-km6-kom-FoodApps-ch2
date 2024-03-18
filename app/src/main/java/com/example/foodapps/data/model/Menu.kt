package com.example.foodapp.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID
@Parcelize
data class Menu(

    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var name: String,
    var price: Double,
    val desc : String,
    val locationUrl : String,
    val locationAddress :String,

) : Parcelable
