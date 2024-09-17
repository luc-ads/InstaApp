package com.example.instaapp.commom.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.databinding.FragmentImageCropperBinding

class CropperImageFragment: Fragment(R.layout.fragment_image_cropper) {

    private var binding: FragmentImageCropperBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentImageCropperBinding.bind(view)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}