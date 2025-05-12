package com.example.mydigikala_mac.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydigikala_mac.Data.CatModel
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.MyImageview

class Adapter_Cat (val imageSetup: ImageSetup): RecyclerView.Adapter<Adapter_Cat.ViewHolder_Cat>() {

    var myCat=ArrayList<CatModel>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_Cat {
        return ViewHolder_Cat(LayoutInflater.from(parent.context).inflate(R.layout.item_cat,parent,false))
    }

    override fun getItemCount(): Int =myCat.size

    override fun onBindViewHolder(holder: ViewHolder_Cat, position: Int) {
        imageSetup.loadImage(holder.img_cat,myCat[position].position)
        holder.txt_title.text=myCat[position].title
    }


    class ViewHolder_Cat(itemView: View) :RecyclerView.ViewHolder(itemView){
        val img_cat:MyImageview=itemView.findViewById(R.id.img_cat_pic)
        val txt_title:TextView=itemView.findViewById(R.id.txt_cat_title)
    }
}