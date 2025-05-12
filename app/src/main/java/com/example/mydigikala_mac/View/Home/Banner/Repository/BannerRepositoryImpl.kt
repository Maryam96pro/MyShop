package com.example.mydigikala_mac.View.Home.Banner.Repository

import com.example.mydigikala_mac.Data.BannerModel
import com.example.mydigikala_mac.View.Home.Banner.DataSource.BannerDataSource
import io.reactivex.rxjava3.core.Single

class BannerRepositoryImpl(val remoteBannerDataSource: BannerDataSource) : BannerRepository {
    override fun getBannerRepository(): Single<List<BannerModel>> = remoteBannerDataSource.getBannerDataSource()

}