package com.example.mydigikala_mac.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydigikala_mac.Data.MyshopModel
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.MyImageview

class Adapter_MyShop(val imageSetup: ImageSetup): RecyclerView.Adapter<Adapter_MyShop.ViewHolder_Home>() {

    var myShop =ArrayList<MyshopModel>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_Home {
        return ViewHolder_Home(LayoutInflater.from(parent.context).inflate(R.layout.fragment_home,parent,false))
    }

    override fun getItemCount(): Int {
        return myShop.size
    }

    override fun onBindViewHolder(holder: ViewHolder_Home, position: Int) {
        holder.txt_title.text=myShop[position].title
        imageSetup.loadImage(holder.img_myshop,myShop[position].position)
    }

    class ViewHolder_Home(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_myshop:MyImageview=itemView.findViewById(R.id.img_myshop_pic)
        val txt_title:TextView=itemView.findViewById(R.id.txt_myshop_title)
    }

}