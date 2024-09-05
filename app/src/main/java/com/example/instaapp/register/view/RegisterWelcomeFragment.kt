package com.example.instaapp.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.databinding.FragmentRegisterWelcomeBinding

class RegisterWelcomeFragment: Fragment(R.layout.fragment_register_welcome) {

    private var binding: FragmentRegisterWelcomeBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterWelcomeBinding.bind(view)
        val name = arguments?.getString(KEY_NAME) ?: throw IllegalArgumentException("Name not found")

        binding?.let {
            with(it) {

                txtWelcomeInsta.text = getString(R.string.welcome_to_instagram, name)

                btnFinishWelcome.isEnabled = true
                btnFinishWelcome.setOnClickListener {
                    fragmentAttachListener?.goToScreenPhoto()
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

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val KEY_NAME = "key_name"
    }
}