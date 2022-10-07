package com.nuriulgen.bitirmeodevi.presentation.home.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nuriulgen.bitirmeodevi.databinding.FragmentHomeDetailBinding
import com.nuriulgen.bitirmeodevi.util.downloadImage


class HomeDetailFragment : Fragment() {

    private lateinit var binding: FragmentHomeDetailBinding
    private val args: HomeDetailFragmentArgs by navArgs()

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

        val temp = args.model
        binding.apply {
              titleText.text = temp.title
              textView3.text = temp.description
             Glide.with(view)
                .load(temp.images?.get(0)?.url.toString())
                .into(binding.backgroundImageView)
        }


     /*   downloadImage(view as ImageView,temp.images?.get(0)?.url.toString())   */

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