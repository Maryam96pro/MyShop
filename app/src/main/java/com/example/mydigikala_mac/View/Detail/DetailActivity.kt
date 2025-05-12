package com.example.mydigikala_mac.View.Detail

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.MyImageview
import com.example.mydigikala_mac.ViewModel.DetailViewModel
import com.example.mydigikala_mac.databinding.ActivityDetailBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding


    val detailViewModel: DetailViewModel by inject { parametersOf(intent.extras!!.getString("key")) }
    val imageSetup: ImageSetup by inject()

    lateinit var img_pic: MyImageview
    lateinit var txt_title: TextView
    lateinit var ratingBar: RatingBar
    lateinit var txt_color: TextView
    lateinit var txt_garantee: TextView
    lateinit var txt_intruduction: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        img_pic = findViewById(R.id.img_detail_pic)
        txt_title = findViewById(R.id.txt_detail_title)
        ratingBar = findViewById(R.id.ratingBar)
        txt_color = findViewById(R.id.txt_detail_color)
        txt_garantee = findViewById(R.id.txt_detail_garuntee)
        txt_intruduction = findViewById(R.id.txt_detial_intruduction)

        detailViewModel.detailLiveData.observe(this) {
            //Log.i("LOG", "OnViewDetail: ${it.toString()}")
            imageSetup.loadImage(img_pic, it[0].image)
            binding.txtDetailTitle.text = it[0].title
            ratingBar.rating = it[0].rating.toFloat()
            binding.txtDetailGaruntee.text = it[0].garantee
            binding.txtDetailColor.text = it[0].colors

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.txtDetialIntruduction.text = (Html.fromHtml(it[0].introduction));
            } else {
                binding.txtDetialIntruduction.text = (Html.fromHtml(it[0].introduction));
            }
        }
    }
}