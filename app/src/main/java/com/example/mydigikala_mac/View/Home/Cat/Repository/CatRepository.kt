package com.example.mydigikala_mac.View.Home.Cat.Repository

import com.example.mydigikala_mac.Data.CatModel
import io.reactivex.rxjava3.core.Single

interface CatRepository {
    fun getCatRepository():Single<List<CatModel>>
}