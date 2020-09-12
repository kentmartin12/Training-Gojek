package com.example.bnccapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bnccapplication.HotlineData
import com.example.bnccapplication.LookUpData
import com.example.bnccapplication.R

class HotlineAdapter(private val lookUpList: MutableList<HotlineData>): RecyclerView.Adapter<HotlineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotlineViewHolder {
        return HotlineViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_look_up,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return lookUpList.size
    }

    override fun onBindViewHolder(holder: HotlineViewHolder, position: Int) {
        holder.bind(lookUpList[position])
    }

    fun updateData(newList: List<HotlineData>){
        lookUpList.clear()
        lookUpList.addAll(newList)

        notifyDataSetChanged()
    }
}