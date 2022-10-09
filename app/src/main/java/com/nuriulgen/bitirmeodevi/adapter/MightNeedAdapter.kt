package com.nuriulgen.bitirmeodevi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.MightNeedRecyclerRowBinding

import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.presentation.guide.view.GuideFragmentDirections
import com.nuriulgen.bitirmeodevi.presentation.search.view.SearchFragmentDirections
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder


class MightNeedAdapter(private val itemList: List<TravelModel>): RecyclerView.Adapter<MightNeedAdapter.MightNeedViewHolder>(){

    class MightNeedViewHolder(var view: MightNeedRecyclerRowBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MightNeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<MightNeedRecyclerRowBinding>(inflater,R.layout.might_need_recycler_row,parent,false)
        return MightNeedViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MightNeedViewHolder, position: Int) {
      holder.view.mightNeedXMl = itemList[position]

        /*
         * Glide ve extension ile image yüklemek.
         */
        itemList[position].images!![0].let {
            holder.view.image.showImage(it.url, showPlaceHolder(holder.itemView.context)) }

        holder.view.image.setOnClickListener {
            val action = GuideFragmentDirections.actionGuideFragmentToHomeDetailFragment(itemList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
}