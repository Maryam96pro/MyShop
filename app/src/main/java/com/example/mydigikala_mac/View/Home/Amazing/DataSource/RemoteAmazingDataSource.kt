package com.example.mydigikala_mac.View.Home.Amazing.DataSource

import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.Request.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteAmazingDataSource (val apiService: ApiService):AmazingDataSource{
    override fun getAmazingDataSource(): Single<List<AmazingModel>> = apiService.getAmazing()
}