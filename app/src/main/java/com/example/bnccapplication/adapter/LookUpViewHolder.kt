package com.example.bnccapplication.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bnccapplication.LookUpData
import kotlinx.android.synthetic.main.item_look_up.view.*

class LookUpViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    fun bind(data: LookUpData){
        itemView.tvLookUpProvinceName.text = data.provinceName
        itemView.tvLooUpConfirmedCase.text = "${data.numberOfPositiveCases}"
        itemView.tvLooUpDeathCase.text = "${data.numberOfDeathCases}"
        itemView.tvLooUpRecoveredCase.text = "${data.numberOfRecoveredCases}"
    }
}