package com.example.mydigikala_mac.View.Home.Cat.Repository

import com.example.mydigikala_mac.Data.CatModel
import com.example.mydigikala_mac.View.Home.Cat.DataSource.CatDataSource
import io.reactivex.rxjava3.core.Single

class CatRepositoryImpl(val remoteCatDataSource: CatDataSource):CatRepository {
    override fun getCatRepository(): Single<List<CatModel>> = remoteCatDataSource.getCatDataSource()
}