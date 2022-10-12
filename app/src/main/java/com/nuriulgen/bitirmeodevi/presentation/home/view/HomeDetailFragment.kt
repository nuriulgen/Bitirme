package com.nuriulgen.bitirmeodevi.presentation.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nuriulgen.bitirmeodevi.databinding.FragmentHomeDetailBinding


class HomeDetailFragment : Fragment() {

    private lateinit var binding: FragmentHomeDetailBinding
    private val args: HomeDetailFragmentArgs by navArgs()

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

        /*
         * detail sayfasına gönderilen değerleri alma işlemi yaptıldı.
         */
        val response = args.model
        binding.apply {
              /**
               * detail sayfasına gelen değerleri ilgili widgetlere gönderildi.
               */
              titleText.text = response.title
              subTitleText.text = response.country
              textView3.text = response.description
             Glide.with(view)
                .load(response.images?.get(0)?.url.toString())
                .into(binding.backgroundImageView)
        }

        binding.zoomButton.setOnClickListener {
            /**
             * Zoom butonuna basınca image full screen gösterilmesi için FullScreenFragment yönlendirildi.
             */
            val action = HomeDetailFragmentDirections.actionHomeDetailFragmentToImageFullScreenFragment(response)
            Navigation.findNavController(it).navigate(action)
        }
    }
}