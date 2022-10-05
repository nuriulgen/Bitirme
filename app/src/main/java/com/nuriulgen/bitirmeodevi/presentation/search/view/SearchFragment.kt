package com.nuriulgen.bitirmeodevi.presentation.search.view

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.adapter.TopDestinationAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentSearchBinding

import com.nuriulgen.bitirmeodevi.domain.model.TopDestinationModel
import com.nuriulgen.bitirmeodevi.presentation.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val topDestinationModel by viewModels<SearchViewModel>()
  /*  private val recyclerAdapter= TopDestinationAdapter(listOf())*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        topDestinationModel.fetchDestination().observe(viewLifecycleOwner) {


            topDestinationRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            topDestinationRecycler.adapter = TopDestinationAdapter(it)


          

        }
    }


}