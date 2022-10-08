package com.nuriulgen.bitirmeodevi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.NearbyAttractionsRecyclerRowBinding
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.presentation.guide.view.GuideFragmentDirections
import com.nuriulgen.bitirmeodevi.presentation.search.view.SearchFragmentDirections
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder


class NearbyAttractionsAdapter(private val itemList: List<TravelModel>):
    RecyclerView.Adapter<NearbyAttractionsAdapter.NearbyAttractionsViewHolder>() {

    class NearbyAttractionsViewHolder(var view: NearbyAttractionsRecyclerRowBinding): RecyclerView.ViewHolder(view.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyAttractionsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<NearbyAttractionsRecyclerRowBinding>(inflater,R.layout.nearby_attractions_recycler_row,parent,false)
        return NearbyAttractionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NearbyAttractionsViewHolder, position: Int) {
        holder.view.nearbyAttractionXMl = itemList[position]

        itemList[position].images?.get(0)?.let { holder.view.backgroundImage.showImage(it.url,
            showPlaceHolder(holder.itemView.context)
        ) }

        holder.view.backgroundImage.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToHomeDetailFragment(itemList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

}