package com.nuriulgen.bitirmeodevi.presentation.home.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.databinding.FragmentHomeBinding
import com.nuriulgen.bitirmeodevi.databinding.FragmentHomeDetailBinding


class HomeDetailFragment : Fragment() {

    private lateinit var binding: FragmentHomeDetailBinding
    private var zoomOut = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    /*    binding.backgroundImageView.setOnClickListener {
            if (zoomOut) {
                Toast.makeText(
                    getApplicationContext(),
                    "NORMAL SIZE!",
                    Toast.LENGTH_LONG
                ).show()
                binding.backgroundImageView.layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                )
                binding.backgroundImageView.adjustViewBounds = true
                zoomOut = false
            } else {
                Toast.makeText(
                    getApplicationContext(),
                    "FULLSCREEN!",
                    Toast.LENGTH_LONG
                ).show()
                binding.backgroundImageView.layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    ConstraintLayout.LayoutParams.MATCH_PARENT
                )
                binding.backgroundImageView.scaleType = ImageView.ScaleType.FIT_XY
                zoomOut = true
            }
        }*/
        binding.likeButton.setOnClickListener {
            val action = HomeDetailFragmentDirections.actionHomeDetailFragmentToImageFullScreenFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


}