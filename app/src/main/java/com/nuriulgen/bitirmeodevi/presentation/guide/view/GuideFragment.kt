package com.nuriulgen.bitirmeodevi.presentation.guide.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.adapter.MightNeedAdapter
import com.nuriulgen.bitirmeodevi.adapter.TopPickAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentGuideBinding

import com.nuriulgen.bitirmeodevi.presentation.guide.viewmodel.GuideViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private val guideViewModel by viewModels<GuideViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuideBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        guideViewModel.fetchMightNeed().observe(viewLifecycleOwner){
            binding.mightNeedRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            binding.mightNeedRecycler.adapter = MightNeedAdapter(it)
        }

        guideViewModel.fetchTopPick().observe(viewLifecycleOwner){
            binding.topPickRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            binding.topPickRecycler.adapter = TopPickAdapter(it)
        }

    }

}