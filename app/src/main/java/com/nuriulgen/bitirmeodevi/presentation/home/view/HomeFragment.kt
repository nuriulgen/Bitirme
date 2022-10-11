package com.nuriulgen.bitirmeodevi.presentation.home.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nuriulgen.bitirmeodevi.adapter.AllAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentHomeBinding

import com.nuriulgen.bitirmeodevi.presentation.home.viewmodel.HomeViewModel
import com.nuriulgen.bitirmeodevi.util.ToastUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /*  tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        viewPager.adapter = ViewPagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)


        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager);*/

        //viewPager.adapter = ViewPagerAdapter(childFragmentManager)
       /* TabLayoutMediator(tabLayout,viewPager){ tab,index ->
            tab.text = when(index) {
                0 -> { "All" }
                1 -> { "Flights" }
                2 -> { "Hotels" }
                3 -> {  "Transportations" }
                else -> {
                    throw Resources.NotFoundException("")
                }
            }
        }.attach()*/


        homeViewModel.fetchAll().observe(viewLifecycleOwner){
            binding.allRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            binding.allRecycler.adapter = AllAdapter(it)
        }

        binding.apply {
            flightsButton.setOnClickListener {
                ToastUtils.showError("Clicked Flights",context)
            }
            hotelsButton.setOnClickListener {
                ToastUtils.showError("Clicked Hotels",context)
            }
            carsButton.setOnClickListener {
                ToastUtils.showError("Clicked Cars",context)
            }
            taxiButton.setOnClickListener {
                ToastUtils.showError("Clicked Taxi",context)
            }
        }
    }

}