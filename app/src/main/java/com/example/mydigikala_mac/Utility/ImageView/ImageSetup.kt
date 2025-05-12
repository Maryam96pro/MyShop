package com.example.mydigikala_mac.Utility.ImageView

import android.widget.ImageView
import okhttp3.Address

interface ImageSetup {
    fun loadImage(imageView: MyImageview,imaAddress: String)
}