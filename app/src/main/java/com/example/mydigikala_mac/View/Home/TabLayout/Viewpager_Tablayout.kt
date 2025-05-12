package com.example.mydigikala_mac.View.Home.TabLayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Viewpager_Tablayout(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 13

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> {
                AllFragment()
            }

            1 -> {
                ForyouFragment()
            }

            2 -> {
                InvestmentFragment()
            }

            3 -> {
                PlayFragment()
            }

            4 -> {
                GiftFragment()
            }

            5 -> {
                MobileFragment()
            }

            6 -> {
                FashionFragment()
            }

            7 -> {
                DigitalProductFragment()
            }

            8 -> {
                TravelFragment()
            }

            9 -> {
                PetFragment()
            }

            10 -> {
                EntertainmentFragment()
            }

            11 -> {
                FreelanceFragment()
            }

            12 -> {
                HomeDecorationFragment()
            }

            13 -> {
                PregnancyFragment()
            }

            else -> {
                Fragment()
            }
        }
}