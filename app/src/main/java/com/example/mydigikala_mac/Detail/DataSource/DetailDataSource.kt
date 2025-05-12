package com.example.mydigikala_mac.Detail.DataSource

import com.example.mydigikala_mac.Data.DetailModel
import io.reactivex.rxjava3.core.Single

interface DetailDataSource {
    fun getDetailDataSource(id:String):Single<List<DetailModel>>
}