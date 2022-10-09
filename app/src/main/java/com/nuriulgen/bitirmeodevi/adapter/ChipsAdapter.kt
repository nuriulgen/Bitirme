package com.nuriulgen.bitirmeodevi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.ChipsRecyclerRowBinding
import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel

class ChipsAdapter(private val itemList: List<GuideModel>): RecyclerView.Adapter<ChipsAdapter.ChipsViewHolder>() {

    class ChipsViewHolder(var view: ChipsRecyclerRowBinding): RecyclerView.ViewHolder(view.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ChipsRecyclerRowBinding>(inflater, R.layout.chips_recycler_row,parent,false)
        return ChipsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChipsViewHolder, position: Int) {
        holder.view.chipsAttractionXMl = itemList[position]
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}