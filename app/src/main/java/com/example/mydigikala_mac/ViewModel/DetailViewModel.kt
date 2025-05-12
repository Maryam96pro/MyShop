package com.example.mydigikala_mac.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.mydigikala_mac.Data.DetailModel
import com.example.mydigikala_mac.Detail.Repository.DetailRepository
import com.example.mydigikala_mac.Utility.Base
import com.example.mydigikala_mac.Utility.MySingleObserve
import com.example.mydigikala_mac.Utility.mySingleHelper

class DetailViewModel(val id:String,val detailRepository: DetailRepository) :Base(){

    val detailLiveData=MutableLiveData<List<DetailModel>>()
    val idLiveData=MutableLiveData<String>()

    init {
        idLiveData.value=id
        detailRepository.getDetailRepository(idLiveData.value!!)
            .mySingleHelper()
            .subscribe(object :MySingleObserve<List<DetailModel>>(compositeDisposable){
                override fun onSuccess(t: List<DetailModel>) {
                    detailLiveData.postValue(t)
                }

            })
    }
}