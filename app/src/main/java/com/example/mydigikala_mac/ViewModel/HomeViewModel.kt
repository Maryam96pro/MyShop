package com.example.mydigikala_mac.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.Data.BannerModel
import com.example.mydigikala_mac.Data.CatModel
import com.example.mydigikala_mac.Utility.Base
import com.example.mydigikala_mac.Utility.MySingleObserve
import com.example.mydigikala_mac.Utility.mySingleHelper
import com.example.mydigikala_mac.View.Home.Amazing.Repository.AmazingRepository
import com.example.mydigikala_mac.View.Home.Banner.Repository.BannerRepository
import com.example.mydigikala_mac.View.Home.Cat.Repository.CatRepository

class HomeViewModel(val bannerRepository: BannerRepository,catRepository: CatRepository,amazingRepository: AmazingRepository):Base() {
    val bannerLiveData=MutableLiveData<List<BannerModel>>()
    val catLiveData=MutableLiveData<List<CatModel>>()
    val amazingLiveData=MutableLiveData<List<AmazingModel>>()


    init {
        bannerRepository.getBannerRepository()
            .mySingleHelper()
            .subscribe(object : MySingleObserve<List<BannerModel>>(compositeDisposable){
                override fun onSuccess(t: List<BannerModel>) {
                    bannerLiveData.postValue(t)
                }

            })


        catRepository.getCatRepository()
            .mySingleHelper()
            .subscribe(object :MySingleObserve<List<CatModel>>(compositeDisposable){
                override fun onSuccess(t: List<CatModel>) {
                    catLiveData.postValue(t)
                }

            })


        amazingRepository.getAmazingRepository()
            .mySingleHelper()
            .subscribe(object :MySingleObserve<List<AmazingModel>>(compositeDisposable){
                override fun onSuccess(t: List<AmazingModel>) {
                    amazingLiveData.postValue(t)
                }

            })













    }







}