package com.example.mydigikala_mac.Detail.DataSource

import com.example.mydigikala_mac.Data.DetailModel
import com.example.mydigikala_mac.Request.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteDetailDataSource(val apiService: ApiService) :DetailDataSource{
    override fun getDetailDataSource(id:String): Single<List<DetailModel>> = apiService.getDetail(id)
}