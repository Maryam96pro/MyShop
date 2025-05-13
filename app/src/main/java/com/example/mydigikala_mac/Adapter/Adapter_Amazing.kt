package com.example.mydigikala_mac.Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydigikala_mac.Data.AmazingModel
import com.example.mydigikala_mac.R
import com.example.mydigikala_mac.Utility.ImageView.ImageSetup
import com.example.mydigikala_mac.Utility.ImageView.MyImageview

  //last acd

class Adapter_Amazing(val imageSetup: ImageSetup,val myAmazing:List<AmazingModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var setDetailItem:SetDetailItem?=null
    fun detailShow(setDetailItem: SetDetailItem){
        this.setDetailItem=setDetailItem
    }

    /*var myAmazing=ArrayList<AmazingModel>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }*/

    override fun getItemViewType(position: Int): Int {


        return when(position){
            0-> ITEM_FIRST
            (myAmazing.size)-1 -> ITEM_LAST
            else -> ITEM_MIDDLE

        }


       /* if (position==0){
            return ITEM_AMAZING_USUALLY
        }else if ((myAmazing.size)-1){
            return ITEM_AMAZING
        }else {
            return ITEM_AMAZING_DIFFERENT
        }*/
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate=LayoutInflater.from(parent.context)
        return when(viewType){
            ITEM_FIRST -> {
                val view=inflate.inflate(R.layout.item_amazing_usually,parent,false)
                ProductViewHolder.ViewHolder_Amazing_Usually(view)

            }
            ITEM_MIDDLE -> {
                val view=inflate.inflate(R.layout.item_amazing,parent,false)
                ProductViewHolder.ViewHolder_Amazing(view)

            }
            else ->{
                val view=inflate.inflate(R.layout.item_amazing_different,parent,false)
                ProductViewHolder.ViewHolder_Amazing_Different(view)

            }


        }
     /*   if (viewType== ITEM_FIRST){
            return ViewHolder_Amazing(LayoutInflater.from(parent.context).inflate(R.layout.item_amazing_usually,parent,false))

        }else if (viewType== ITEM_MIDDLE){
            return ViewHolder_Amazing(LayoutInflater.from(parent.context).inflate(R.layout.item_amazing,parent,false))

        }else {
            return ViewHolder_Amazing(LayoutInflater.from(parent.context).inflate(R.layout.item_amazing_different,parent,false))

        }*/
    }

    override fun getItemCount(): Int =myAmazing.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemAmazing =myAmazing[position]

        when(holder){
            is ProductViewHolder.ViewHolder_Amazing_Usually-> {

                imageSetup.loadImage(holder.img_amazing_usually_pic,itemAmazing.image)
                (holder).txt_amazing_usually_title.text=itemAmazing.title
                (holder ).txt_amazing_usually_price.text=itemAmazing.price
                (holder ).txt_amazing_usually_pprice.text=itemAmazing.pprice

            }
            is ProductViewHolder.ViewHolder_Amazing-> {
                imageSetup.loadImage(holder.img_amazing_pic,itemAmazing.image)
                (holder as ProductViewHolder.ViewHolder_Amazing).txt_amazing_title.text=itemAmazing.title
                (holder as ProductViewHolder.ViewHolder_Amazing).txt_amazing_price.text=itemAmazing.price

                (holder as ProductViewHolder.ViewHolder_Amazing).txt_amazing_pprice.text=itemAmazing.pprice

            }
            is ProductViewHolder.ViewHolder_Amazing_Different ->{
             //   (holder as ProductViewHolder.ViewHolder_Amazing_Different).txt_amazing_different_title.text="مشاهده همه"



            }
        }

       /* if (getItemViewType(position)== ITEM_FIRST){
            (holder as ViewHolder_Amazing_Usually).txt_amazing_usually_title.text=itemAmazing.title
            (holder as ViewHolder_Amazing_Usually).txt_amazing_usually_price.text=itemAmazing.price
            (holder as ViewHolder_Amazing_Usually).txt_amazing_usually_pprice.text=itemAmazing.pprice
            imageSetup.loadImage(holder.img_amazing_usually_pic,itemAmazing.image)




        }else if (getItemViewType(position)== ITEM_MIDDLE){

            (holder as ViewHolder_Amazing).txt_amazing_title.text=itemAmazing.title
            (holder as ViewHolder_Amazing).txt_amazing_price.text=itemAmazing.price
            (holder as ViewHolder_Amazing).txt_amazing_pprice.text=itemAmazing.pprice
            imageSetup.loadImage(holder.img_amazing_pic,itemAmazing.image)

            holder.itemView.setOnClickListener{
                setDetailItem?.detailItem(itemAmazing)
            }
        }*/

    }
    sealed class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        class ViewHolder_Amazing_Usually(itemView: View) : ProductViewHolder(itemView) {
            val img_amazing_usually_pic:MyImageview=itemView.findViewById(R.id.img_amazing_usually_pic)
            val txt_amazing_usually_title:TextView=itemView.findViewById(R.id.txt_amazing_usually_title)
            val txt_amazing_usually_pprice:TextView=itemView.findViewById(R.id.txt_amazing_usually_pprice)
            val txt_amazing_usually_price:TextView=itemView.findViewById(R.id.txt_amazing_usually_price)
        }

        class ViewHolder_Amazing(itemView: View) : ProductViewHolder(itemView) {
            val img_amazing_pic:MyImageview=itemView.findViewById(R.id.img_amazing_pic)
            val txt_amazing_title:TextView=itemView.findViewById(R.id.txt_amazing_title)
            val txt_amazing_pprice:TextView=itemView.findViewById(R.id.txt_amazing_pprice)
            val txt_amazing_price:TextView=itemView.findViewById(R.id.txt_amazing_price)
        }

        class ViewHolder_Amazing_Different(itemView: View) : ProductViewHolder(itemView) {

            val img_amazing_different_pic:ImageView=itemView.findViewById(R.id.img_amazing_different_pic)
            val txt_amazing_different_title:TextView=itemView.findViewById(R.id.txt_amazing_different_title)
        }

    }

    companion object{
        const val ITEM_FIRST=0  //first acd
        const val ITEM_MIDDLE=1 // middle
        const val ITEM_LAST=2
    }


}

interface SetDetailItem{
    fun detailItem(amazingModel: AmazingModel)
}