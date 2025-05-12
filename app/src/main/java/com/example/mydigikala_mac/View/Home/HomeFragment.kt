package com.example.mydigikala_mac.View.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.View.Home.TabLayout.Viewpager_Tablayout
import com.example.mydigikala_mac.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!

    lateinit var mytabLayout: TabLayout
    lateinit var myViewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val myViewpager_Tablayout = Viewpager_Tablayout(this)
        binding.homeViewpager.adapter=myViewpager_Tablayout

        TabLayoutMediator(binding.tableLayout, binding.homeViewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "همه"
                1 -> tab.text = "برای شما"
                2 -> tab.text = "سرمایه گذاری"
                3 -> tab.text = "هدیه"
                4 -> tab.text = "بازی"
                5 -> tab.text = "لوازم جانبی موبایل"
                6 -> tab.text = "مد و پوشاک"
                7 -> tab.text = "کالای دیجیتال"
                8 -> tab.text = "سفر"
                9 -> tab.text = "حیوان خانگی"
                10 -> tab.text = "سرگرمی دورهمی"
                11 -> tab.text = "فریلسری"
                12 -> tab.text = "تریین خانه"
                13 -> tab.text = "بارداری و نوزاد"
            }

        }.attach()


    }
}