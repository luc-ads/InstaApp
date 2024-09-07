package com.example.instaapp.register.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.commom.view.CustomDialog
import com.example.instaapp.databinding.FragmentRegisterAddPhotosBinding
import com.example.instaapp.databinding.FragmentRegisterWelcomeBinding


class RegisterAddPhotosFragment: Fragment() {

    private var binding: FragmentRegisterAddPhotosBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

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
                    val customDialog = CustomDialog(requireContext())
                    customDialog.addButton(R.string.photo, R.string.gallery, R.string.app_name) {
                        when (it.id) {
                            R.string.photo -> {
                                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                                startActivity(intent)
                            }
                            R.string.gallery -> {

                            }
                        }
                    }
                    customDialog.show()
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
}