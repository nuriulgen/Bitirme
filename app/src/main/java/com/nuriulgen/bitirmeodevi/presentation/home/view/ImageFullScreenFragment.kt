package com.nuriulgen.bitirmeodevi.presentation.home.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nuriulgen.bitirmeodevi.databinding.FragmentImageFullScreenBinding


class ImageFullScreenFragment : Fragment() {

    private lateinit var binding: FragmentImageFullScreenBinding
    private val args: ImageFullScreenFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageFullScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val response = args.imageModel
        binding.apply {
            /**
             * detail sayfasına gelen image full screen yapıldı.
             */
            Glide.with(view)
                .load(response.images?.get(0)?.url.toString())
                .into(binding.fullScreemImageView)

        }

        binding.backButton.setOnClickListener {
            /*
             * back butona basıldıktan sonra geri detail sayfasına gönderilme işlemi yapıldı.
             */
            val navController = findNavController();
            navController.popBackStack()
        }
    }
}