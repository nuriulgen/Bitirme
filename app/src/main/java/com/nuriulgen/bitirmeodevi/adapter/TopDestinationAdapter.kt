package com.nuriulgen.bitirmeodevi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.domain.model.TopDestinationModel
import kotlinx.android.synthetic.main.top_destination_recycler_row.view.*

class TopDestinationAdapter(val itemList: List<TopDestinationModel>): RecyclerView.Adapter<TopDestinationAdapter.TopDestinationViewHolder>() {

    class TopDestinationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDestinationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.top_destination_recycler_row,parent,false)
        return TopDestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopDestinationViewHolder, position: Int) {
      holder.itemView.titleText.text = itemList[position].title
      holder.itemView.subTitleText.text = itemList[position].country
    }

    override fun getItemCount(): Int {
      return itemList.size
    }


}