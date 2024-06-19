package com.example.recycleview2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fibonacciseries.R

class NumbersRecycleViewAdapter (var number:List<Int>):RecyclerView.Adapter<NumberView>(){

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberView {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(
                R.layout.number_list_item,
                parent,
                false
            )
        return NumberView(itemView)
    }


    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: NumberView, position: Int) {
        holder.tvNumber.text= number[position].toString()
    }
}

class NumberView(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvNumber=itemView.findViewById<TextView>(R.id.tvNumber)
}