package com.nuriulgen.bitirmeodevi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.domain.model.topDestination.TopDestinationModel
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder
import kotlinx.android.synthetic.main.top_destination_recycler_row.view.*

class TopDestinationAdapter(private val itemList: List<TopDestinationModel>): RecyclerView.Adapter<TopDestinationAdapter.TopDestinationViewHolder>() {

    class TopDestinationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDestinationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.top_destination_recycler_row,parent,false)
        return TopDestinationViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: TopDestinationViewHolder, position: Int) {
      holder.itemView.titleText.text = itemList[position].city
      holder.itemView.subTitleText.text = itemList[position].country
        itemList[position].images?.get(0)?.let { holder.itemView.imageView.showImage(it.url,
            showPlaceHolder(holder.itemView.context)
        ) }
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

}