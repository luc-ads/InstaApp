package com.example.instaapp.register.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.instaapp.MainActivity
import com.example.instaapp.R
import com.example.instaapp.commom.util.replaceFragment
import com.example.instaapp.commom.view.CropperImageFragment
import com.example.instaapp.commom.view.CropperImageFragment.Companion.KEY_URI
import com.example.instaapp.databinding.ActivityRegisterBinding
import com.example.instaapp.register.view.RegisterWelcomeFragment.Companion.KEY_NAME
import com.example.instaapp.register.view.nameAndPassword.RegisterNamePasswordFragment.Companion.KEY_EMAIL
import com.example.instaapp.register.view.email.RegisterEmailFragment
import com.example.instaapp.register.view.nameAndPassword.RegisterNamePasswordFragment
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.jvm.Throws

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var currentPhoto: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterEmailFragment()
        replaceFragment(R.id.register_fragment, fragment)
    }

    override fun goToNameAndPasswordScreen(email: String) {
        val bundle = Bundle()
        bundle.putString(KEY_EMAIL, email)

        val fragment = RegisterNamePasswordFragment().apply {
            arguments = bundle
        }

        replaceFragment(R.id.register_fragment, fragment)
    }

    override fun goToWelcomeScreen(name: String) {
        val bundle = Bundle()
        bundle.putString(KEY_NAME, name)

        val fragment = RegisterWelcomeFragment().apply {
            arguments = bundle
        }

        replaceFragment(R.id.register_fragment, fragment)
    }

    override fun goToScreenPhoto() {
        replaceFragment(R.id.register_fragment, RegisterAddPhotosFragment())
    }

    override fun goToMainScreen() {
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        })
    }

    override fun goToGalleryScreen() {
        getContent.launch("image/*")
    }

    override fun goToCameraScreen() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            val photoFile: File? = try {
                createImageFile()
            } catch (e: IOException) {
                Log.e("RegisterActivity", e.message, e)
                null
            }

            photoFile?.also {
                val photoUri = FileProvider.getUriForFile(this, "com.example.instaapp.fileprovider", it)
                currentPhoto = photoUri

                getCamera.launch(photoUri)
            }
        }
    }

    private val getCamera = registerForActivityResult(ActivityResultContracts.TakePicture()) { saved ->
        if (saved) {
            openImageCropper(currentPhoto)
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File.createTempFile("JPEG_${timestamp}_", ".jpg", dir)
    }

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let { openImageCropper(it) }
    }

    private fun openImageCropper(uri: Uri) {
        val fragment = CropperImageFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_URI, uri)
            }
        }

        replaceFragment(R.id.register_fragment, fragment)
    }
}