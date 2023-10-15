package com.example.instaapp.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.commom.CustomDialog


class RegisterAddPhotosFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_add_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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