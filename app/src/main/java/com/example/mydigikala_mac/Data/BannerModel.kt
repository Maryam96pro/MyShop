package com.example.mydigikala_mac.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BannerModel(
    val id: Int,
    val pic: String,
    val type: Int
) : Parcelable