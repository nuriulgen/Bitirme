package com.nuriulgen.bitirmeodevi.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.AllRecyclerRowBinding
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.presentation.home.view.HomeFragmentDirections
import com.nuriulgen.bitirmeodevi.presentation.search.view.SearchFragmentDirections
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder


class AllAdapter(private val itemList: List<TravelModel>): RecyclerView.Adapter<AllAdapter.AllViewHolder>(){

    class AllViewHolder(var view: AllRecyclerRowBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<AllRecyclerRowBinding>(inflater,R.layout.all_recycler_row,parent,false)
        return AllViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllViewHolder, position: Int) {
        /*
         * Glide ve extension ile image yüklemek.
         */
        itemList[position].images?.get(0)?.let { holder.view.allImage.showImage(it.url,
            showPlaceHolder(holder.itemView.context)
        ) }
        holder.view.allImage.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToHomeDetailFragment(itemList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
}