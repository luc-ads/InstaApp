package com.example.instaapp.register.view

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.instaapp.R
import com.example.instaapp.commom.view.CropperImageFragment
import com.example.instaapp.commom.view.CustomDialog
import com.example.instaapp.databinding.FragmentRegisterAddPhotosBinding
import com.example.instaapp.databinding.FragmentRegisterWelcomeBinding


class RegisterAddPhotosFragment: Fragment(R.layout.fragment_register_add_photos) {

    private var binding: FragmentRegisterAddPhotosBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("cropKey") {requestKey: String, bundle: Bundle ->  
            val uri = bundle.getParcelable<Uri>(CropperImageFragment.KEY_URI)
            onCropImageResult(uri)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterAddPhotosBinding.bind(view)

        binding?.let {
            with(it) {

                linkJump.setOnClickListener {
                    fragmentAttachListener?.goToMainScreen()
                }

                btnNextStep.isEnabled = true
                btnNextStep.setOnClickListener {
                    openDialog()
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }


    private fun onCropImageResult(uri: Uri?) {
         if (uri != null) {
             val bitmap = if (Build.VERSION.SDK_INT >= 28) {
                 val source = ImageDecoder.createSource(requireContext().contentResolver, uri)
                 ImageDecoder.decodeBitmap(source)
             } else {
                 MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)
             }
             binding?.registerImgProfile?.setImageBitmap(bitmap)

         }
    }

    private fun openDialog() {
        val customDialog = CustomDialog(requireContext())
        customDialog.addButton(R.string.photo, R.string.gallery, R.string.app_name) {
            when (it.id) {
                R.string.photo -> {
                    fragmentAttachListener?.goToCameraScreen()
                }
                R.string.gallery -> {
                    fragmentAttachListener?.goToGalleryScreen()
                }
            }
        }
        customDialog.show()
    }
}