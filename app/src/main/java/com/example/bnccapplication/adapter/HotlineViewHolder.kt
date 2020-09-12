package com.example.bnccapplication.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bnccapplication.HotlineData
import com.example.bnccapplication.LookUpData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_look_up.view.*

class HotlineViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    fun bind(data: HotlineData){
        itemView.tvLookUpProvinceName.text = data.name
        if(data.imgIcon.isNotBlank()){
            Picasso.get().load(data.imgIcon).into(itemView.imgHotline)
        }
    }
}