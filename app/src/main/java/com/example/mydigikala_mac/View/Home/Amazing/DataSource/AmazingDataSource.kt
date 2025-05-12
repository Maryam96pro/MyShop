package com.example.mydigikala_mac.View.Home.Amazing.DataSource

import com.example.mydigikala_mac.Data.AmazingModel
import io.reactivex.rxjava3.core.Single

interface AmazingDataSource {
    fun getAmazingDataSource():Single<List<AmazingModel>>
}