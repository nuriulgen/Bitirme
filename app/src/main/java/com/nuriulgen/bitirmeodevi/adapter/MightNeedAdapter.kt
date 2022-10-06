package com.nuriulgen.bitirmeodevi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.domain.model.mightNeed.MightNeedModel
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder
import kotlinx.android.synthetic.main.might_need_recycler_row.view.*
import kotlinx.android.synthetic.main.top_destination_recycler_row.view.*

class MightNeedAdapter(private val itemList: List<MightNeedModel>):
RecyclerView.Adapter<MightNeedAdapter.MightNeedViewHolder>(){

    class MightNeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MightNeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.might_need_recycler_row,parent,false)
        return MightNeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MightNeedViewHolder, position: Int) {
        holder.itemView.mightTitle.text = itemList[position].country

        /*
         * Glide ve extension ile image yüklemek.
         */
        itemList[position].images?.get(0)?.let { holder.itemView.image.showImage(it.url,
            showPlaceHolder(holder.itemView.context)
        ) }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
}