package com.example.mydigikala_mac.View.Home

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydigikala_mac.Data.BannerModel
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.ImageSetupImpl
import com.example.mydigikala_mac.Utility.ImageView.MyImageview
import com.example.mydigikala_mac.databinding.FragmentSliderBinding
import org.koin.android.ext.android.inject

class SliderFragment : Fragment() {
    private var _binding:FragmentSliderBinding?=null
    private val binding get()=_binding!!



   val imageSetup : ImageSetup by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val bannerRecive= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("key",BannerModel::class.java)
        } else {
            arguments?.getParcelable<BannerModel>("key")
        }
   _binding= FragmentSliderBinding.inflate(inflater, container, false)
        imageSetup.loadImage(binding.imgSlider,bannerRecive!!.pic)
        return binding.root
    }


    companion object{
        fun newInstance(bannerModel: BannerModel):SliderFragment{
            return SliderFragment().apply {
                arguments=Bundle().apply {
                    putParcelable("key",bannerModel)
                }
            }
        }
    }

}