package com.example.mydigikala_mac.View.Home.Banner.DataSource

import com.example.mydigikala_mac.Data.BannerModel
import com.example.mydigikala_mac.Request.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteBannerDataSource(val apiService: ApiService):BannerDataSource {
    override fun getBannerDataSource(): Single<List<BannerModel>> = apiService.getBanner()

}