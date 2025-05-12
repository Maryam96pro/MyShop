package com.example.mydigikala_mac.View.Home.Banner.DataSource

import com.example.mydigikala_mac.Data.BannerModel
import io.reactivex.rxjava3.core.Single

interface BannerDataSource {
    fun getBannerDataSource():Single<List<BannerModel>>
}