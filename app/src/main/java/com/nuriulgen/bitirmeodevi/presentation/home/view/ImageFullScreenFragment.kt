package com.nuriulgen.bitirmeodevi.presentation.home.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nuriulgen.bitirmeodevi.databinding.FragmentImageFullScreenBinding


class ImageFullScreenFragment : Fragment() {

    private lateinit var binding: FragmentImageFullScreenBinding
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

        val bundle = arguments
        val imagePath = bundle!!.getString("image")


        val bitmap = BitmapFactory.decodeFile(imagePath)
        binding.fullScreemImageView.setImageBitmap(bitmap)
    }

}