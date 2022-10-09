package com.nuriulgen.bitirmeodevi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.ListItemRecyclerRowBinding
import com.nuriulgen.bitirmeodevi.domain.model.AddItemModel


class AddItemAdapter(val c: Context, private val itemList:ArrayList<AddItemModel> ): RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder>() {

    class AddItemViewHolder(var view: ListItemRecyclerRowBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ListItemRecyclerRowBinding>(inflater,R.layout.list_item_recycler_row,parent,false)
        return AddItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        val newList = itemList[position]
        holder.view.apply {
            listTitle.text = newList.title
            listSubTitle.text = newList.subTitle
            timeText.text = newList.days
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}