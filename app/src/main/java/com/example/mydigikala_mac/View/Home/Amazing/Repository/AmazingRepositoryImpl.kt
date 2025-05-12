package com.example.mydigikala_mac.View.Home.Amazing.Repository

import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.View.Home.Amazing.DataSource.AmazingDataSource
import com.example.mydigikala_mac.View.Home.Amazing.DataSource.RemoteAmazingDataSource
import io.reactivex.rxjava3.core.Single

class AmazingRepositoryImpl(val remoteAmazingDataSource: AmazingDataSource):AmazingRepository {
    override fun getAmazingRepository(): Single<List<AmazingModel>> = remoteAmazingDataSource.getAmazingDataSource()
}