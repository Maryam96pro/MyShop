package com.example.mydigikala_mac.Request

import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.Data.BannerModel
import com.example.mydigikala_mac.Data.CatModel
import com.example.mydigikala_mac.Data.DetailModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("readbanner.php")
    fun getBanner(): Single<List<BannerModel>>

    @GET("getcat.php")
    fun getCat(): Single<List<CatModel>>

    @GET("readamazing.php")
    fun getAmazing():Single<List<AmazingModel>>

    @GET("getdetail.php")
    fun getDetail(@Query("id") id:String):Single<List<DetailModel>>

}

fun getApiClient(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.35/Digikala_Project/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)

}