package com.example.mydigikala_mac.Utility

import android.app.Application
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mydigikala_mac.Adapter.Adapter_Amazing
import com.example.mydigikala_mac.Adapter.Adapter_Cat
import com.example.mydigikala_mac.Detail.DataSource.RemoteDetailDataSource
import com.example.mydigikala_mac.Detail.Repository.DetailRepository
import com.example.mydigikala_mac.Detail.Repository.DetailRepositoryImpl
import com.example.mydigikala_mac.Request.getApiClient
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.ImageSetupImpl
import com.example.mydigikala_mac.View.Home.Amazing.DataSource.RemoteAmazingDataSource
import com.example.mydigikala_mac.View.Home.Amazing.Repository.AmazingRepository
import com.example.mydigikala_mac.View.Home.Amazing.Repository.AmazingRepositoryImpl
import com.example.mydigikala_mac.View.Home.Banner.DataSource.RemoteBannerDataSource
import com.example.mydigikala_mac.View.Home.Banner.Repository.BannerRepository
import com.example.mydigikala_mac.View.Home.Banner.Repository.BannerRepositoryImpl
import com.example.mydigikala_mac.View.Home.Cat.DataSource.RemoteCatDataSource
import com.example.mydigikala_mac.View.Home.Cat.Repository.CatRepository
import com.example.mydigikala_mac.View.Home.Cat.Repository.CatRepositoryImpl
import com.example.mydigikala_mac.ViewModel.DetailViewModel
import com.example.mydigikala_mac.ViewModel.HomeViewModel
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)


        val myModule = module {
            single { getApiClient() }
            single <ImageSetup>{ ImageSetupImpl() }


            factory <BannerRepository>{ BannerRepositoryImpl(RemoteBannerDataSource(get())) }

            factory <CatRepository>{ CatRepositoryImpl(RemoteCatDataSource(get())) }
            factory { Adapter_Cat(get()) }

            factory <AmazingRepository>{ AmazingRepositoryImpl(RemoteAmazingDataSource(get())) }
            factory { Adapter_Amazing(get()) }

            factory <DetailRepository>{ DetailRepositoryImpl(RemoteDetailDataSource(get())) }

            viewModel { HomeViewModel(get(),get(),get()) }
            viewModel { (id:String)->DetailViewModel(id,get()) }

        }


        startKoin {
            androidContext(this@App)
            modules(myModule)
        }

    }
}