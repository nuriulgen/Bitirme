package com.nuriulgen.bitirmeodevi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.TopDestinationRecyclerRowBinding

import com.nuriulgen.bitirmeodevi.domain.model.topDestination.TopDestinationModel
import com.nuriulgen.bitirmeodevi.presentation.search.view.SearchFragmentDirections
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder


class TopDestinationAdapter(private val itemList: List<TopDestinationModel>):
    RecyclerView.Adapter<TopDestinationAdapter.TopDestinationViewHolder>() {

    class TopDestinationViewHolder(var view: TopDestinationRecyclerRowBinding): RecyclerView.ViewHolder(view.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDestinationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<TopDestinationRecyclerRowBinding>(inflater,R.layout.top_destination_recycler_row,parent,false)
        return TopDestinationViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: TopDestinationViewHolder, position: Int) {
      holder.view.topDestinationXMl = itemList[position]
        /*
        * Glide ve extension ile image yüklemek.
        */
        itemList[position].images?.get(0)?.let { holder.view.imageView.showImage(it.url,
            showPlaceHolder(holder.itemView.context)
        ) }

      holder.view.imageView.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToHomeDetailFragment(itemList[position])
            findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

}