package com.example.mydigikala_mac.View.Home.Cat.DataSource

import com.example.mydigikala_mac.Data.CatModel
import io.reactivex.rxjava3.core.Single

interface CatDataSource {
    fun getCatDataSource(): Single<List<CatModel>>
}