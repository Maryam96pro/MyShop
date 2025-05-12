package com.example.mydigikala_mac.View.Home.TabLayout

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mydigikala_mac.Adapter.Adapter_Amazing
import com.example.mydigikala_mac.Adapter.Adapter_Cat
import com.example.mydigikala_mac.Adapter.SetDetailItem
import com.example.mydigikala_mac.Adapter.ViewPager_Banner
import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.Data.CatModel
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.View.Detail.DetailActivity
import com.example.mydigikala_mac.ViewModel.HomeViewModel
import com.example.mydigikala_mac.databinding.FragmentAllBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class AllFragment : Fragment() ,SetDetailItem{
    private var _binding:FragmentAllBinding?=null
    private val binding get() =_binding!!


    val homeViewModel: HomeViewModel by viewModel()

//    lateinit var myTimer: TextView
//    lateinit var myViewpager:ViewPager2
//    lateinit var dots:DotsIndicator
//    lateinit var rv_cat: RecyclerView
//    lateinit var rv_amazing: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        homeViewModel.bannerLiveData.observe(viewLifecycleOwner) {
            //Log.i("LOG", "OnViewBanner: ${it.toString()}")
            val myViewPager_Banner = ViewPager_Banner(this, it)
            binding.viewpagerAllBanner.adapter = myViewPager_Banner
            binding.dotsIndicator.attachTo(binding.viewpagerAllBanner)
            binding.viewpagerAllBanner.isUserInputEnabled = true
            binding.viewpagerAllBanner.getChildAt(0)?.overScrollMode = View.OVER_SCROLL_NEVER
            binding.viewpagerAllBanner.getChildAt(0)?.setOnTouchListener { v, event ->
                v.parent.requestDisallowInterceptTouchEvent(true)
                false
            }
        }


        //val rv_cat: RecyclerView = view.findViewById(R.id.rv_all_cat)
        binding.rvAllCat.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        homeViewModel.catLiveData.observe(viewLifecycleOwner) {
            //Log.i("LOG", "OnViewCat: ${it.toString()}")
            val myAdapter_Cat: Adapter_Cat by inject()
            myAdapter_Cat.myCat = it as ArrayList<CatModel>
            binding.rvAllCat.adapter = myAdapter_Cat

        }


        //textView = view.findViewById(R.id.txt_all_timer)

        object : CountDownTimer(21600000, 1000) {
            override fun onTick(p0: Long) {
                val hours: Long = (p0 / 1000) / 3600
                val minutes: Long = ((p0 / 1000) % 3600) / 60
                val second: Long = (p0 / 1000) % 60
                binding.txtAllTimer.text=String.format("%02d:%02d:%02d",hours,minutes,second)
            }

            override fun onFinish() {
                binding.txtAllTimer.text="تخفیف به پایان رسید"
            }

        }.start()

        //val rv_amazing: RecyclerView = view.findViewById(R.id.rv_all_amazing)
       binding.rvAllAmazing.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        homeViewModel.amazingLiveData.observe(viewLifecycleOwner){
           // Log.i("LOG", "OnViewAmazing: ${it.toString()}")
            val myAdapter_Amazing :Adapter_Amazing by inject()
            myAdapter_Amazing.detailShow(this)
            myAdapter_Amazing.myAmazing= it as ArrayList<AmazingModel>
            binding.rvAllAmazing.adapter=myAdapter_Amazing
        }


    }

    override fun detailItem(amazingModel: AmazingModel) {
        startActivity(Intent(context,DetailActivity::class.java).apply {
            putExtra("key",amazingModel.id)
        })
    }

}