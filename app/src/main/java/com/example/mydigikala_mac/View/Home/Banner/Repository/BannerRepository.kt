package com.example.mydigikala_mac.View.Home.Banner.Repository

import com.example.mydigikala_mac.Data.BannerModel
import io.reactivex.rxjava3.core.Single

interface BannerRepository {
    fun getBannerRepository():Single<List<BannerModel>>
}