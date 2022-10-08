package com.nuriulgen.bitirmeodevi.presentation.home.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuriulgen.bitirmeodevi.adapter.AllAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentHomeBinding
import com.nuriulgen.bitirmeodevi.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

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

        homeViewModel.fetchAll().observe(viewLifecycleOwner){
            binding.allRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            binding.allRecycler.adapter = AllAdapter(it)
        }
    }

}