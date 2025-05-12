package com.example.mydigikala_mac.Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.MyImageview

class Adapter_Amazing(val imageSetup: ImageSetup): RecyclerView.Adapter<Adapter_Amazing.ViewHolder_Amazing>() {

    var setDetailItem:SetDetailItem?=null
    fun detailShow(setDetailItem: SetDetailItem){
        this.setDetailItem=setDetailItem
    }

    var myAmazing=ArrayList<AmazingModel>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_Amazing {
        return ViewHolder_Amazing(LayoutInflater.from(parent.context).inflate(R.layout.item_amazing,parent,false))
    }

    override fun getItemCount(): Int =myAmazing.size

    override fun onBindViewHolder(holder: ViewHolder_Amazing, position: Int) {
        val itemAmazing=myAmazing[position]
        imageSetup.loadImage(holder.img_pic,itemAmazing.image)
        holder.txt_title.text=itemAmazing.title
        holder.txt_pprice.text=itemAmazing.price
        holder.txt_price.paintFlags=Paint.STRIKE_THRU_TEXT_FLAG
        holder.txt_price.text=itemAmazing.pprice

        holder.itemView.setOnClickListener {
            setDetailItem?.detailItem(itemAmazing)
        }

    }

    class ViewHolder_Amazing(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_pic:MyImageview=itemView.findViewById(R.id.img_amazing_pic)
        val txt_title:TextView=itemView.findViewById(R.id.txt_amazing_title)
        val txt_pprice:TextView=itemView.findViewById(R.id.txt_amazing_pprice)
        val txt_price:TextView=itemView.findViewById(R.id.txt_amazing_price)
    }
}

interface SetDetailItem{
    fun detailItem(amazingModel: AmazingModel)
}