package com.example.mydigikala_mac.View.Home.Amazing.Repository

import com.example.mydigikala_mac.Data.AmazingModel
import io.reactivex.rxjava3.core.Single

interface AmazingRepository {
    fun getAmazingRepository():Single<List<AmazingModel>>
}