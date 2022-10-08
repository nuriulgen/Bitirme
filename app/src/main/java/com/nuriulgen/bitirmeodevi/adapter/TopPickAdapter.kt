package com.nuriulgen.bitirmeodevi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.TopPickRecyclerRowBinding
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.presentation.guide.view.GuideFragmentDirections
import com.nuriulgen.bitirmeodevi.util.showImage
import com.nuriulgen.bitirmeodevi.util.showPlaceHolder

class TopPickAdapter(private val model: List<TravelModel>) : RecyclerView.Adapter<TopPickAdapter.TopPickViewHolder>() {

    class TopPickViewHolder(var view: TopPickRecyclerRowBinding): RecyclerView.ViewHolder(view.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPickViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<TopPickRecyclerRowBinding>(inflater, R.layout.top_pick_recycler_row,parent,false)
        return TopPickViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopPickViewHolder, position: Int) {
        holder.view.title.text = model[position].title
        holder.view.title.text = model[position].description

        model[position].images?.get(0)?.let { holder.view.imageView4.showImage(it.url,
            showPlaceHolder(holder.itemView.context)
        ) }
        holder.view.imageView4.setOnClickListener {
            val action = GuideFragmentDirections.actionGuideFragmentToHomeDetailFragment(model[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return model.size
    }
}