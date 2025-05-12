package com.example.mydigikala_mac.Utility

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class Base :ViewModel() {

    val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

    fun<T : Any> Single<T>.mySingleHelper():Single<T>{
        return subscribeOn(Schedulers.io())
        observeOn(AndroidSchedulers.mainThread())
    }


    abstract class MySingleObserve<T : Any>(val compositeDisposable: CompositeDisposable):SingleObserver<T>{
         override fun onSubscribe(d: Disposable) {
             compositeDisposable.add(d)
         }

         override fun onError(e: Throwable) {
             Log.i("TAG", "onError: ${e.toString()}")
         }
}