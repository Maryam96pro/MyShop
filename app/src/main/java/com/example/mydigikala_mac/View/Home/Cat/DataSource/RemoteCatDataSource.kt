package com.example.mydigikala_mac.View.Home.Cat.DataSource

import com.example.mydigikala_mac.Data.CatModel
import com.example.mydigikala_mac.Request.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteCatDataSource(val apiService: ApiService):CatDataSource {
    override fun getCatDataSource(): Single<List<CatModel>> = apiService.getCat()
}