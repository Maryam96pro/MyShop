package com.example.mydigikala_mac.Detail.Repository

import com.example.mydigikala_mac.Data.DetailModel
import io.reactivex.rxjava3.core.Single

interface DetailRepository {
    fun getDetailRepository(id:String):Single<List<DetailModel>>
}