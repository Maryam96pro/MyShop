package com.example.mydigikala_mac.Detail.Repository

import com.example.mydigikala_mac.Data.DetailModel
import com.example.mydigikala_mac.Detail.DataSource.DetailDataSource
import com.example.mydigikala_mac.Detail.DataSource.RemoteDetailDataSource
import io.reactivex.rxjava3.core.Single

class DetailRepositoryImpl(val remoteDetailDataSource: DetailDataSource) :DetailRepository{
    override fun getDetailRepository(id: String): Single<List<DetailModel>> = remoteDetailDataSource.getDetailDataSource(id)
}