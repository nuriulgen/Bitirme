package com.nuriulgen.bitirmeodevi.presentation.search.view

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuriulgen.bitirmeodevi.adapter.NearbyAttractionsAdapter
import com.nuriulgen.bitirmeodevi.adapter.TopDestinationAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentSearchBinding
import com.nuriulgen.bitirmeodevi.presentation.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel by viewModels<SearchViewModel>()

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

        searchViewModel.fetchDestination().observe(viewLifecycleOwner) {
            topDestinationRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            topDestinationRecycler.adapter = TopDestinationAdapter(it)
        }
        searchViewModel.fetchNearbyAttractions().observe(viewLifecycleOwner){
           nearbyAttractionsRecycler.layoutManager = LinearLayoutManager(context)
           nearbyAttractionsRecycler.adapter = NearbyAttractionsAdapter(it)

        }


    }


}