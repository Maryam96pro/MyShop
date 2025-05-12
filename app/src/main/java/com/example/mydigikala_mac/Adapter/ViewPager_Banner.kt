package com.example.mydigikala_mac.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mydigikala_mac.Data.BannerModel
import com.example.mydigikala_mac.View.Home.SliderFragment

class ViewPager_Banner(fragment: Fragment,val bannerModel: List<BannerModel>):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = bannerModel.size

    override fun createFragment(position: Int): Fragment = SliderFragment.newInstance(bannerModel[position])
}