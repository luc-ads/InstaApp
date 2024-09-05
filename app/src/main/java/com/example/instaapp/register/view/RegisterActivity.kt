package com.example.instaapp.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.databinding.ActivityRegisterBinding
import com.example.instaapp.register.view.RegisterWelcomeFragment.Companion.KEY_NAME
import com.example.instaapp.register.view.nameAndPassword.RegisterNamePasswordFragment.Companion.KEY_EMAIL
import com.example.instaapp.register.view.email.RegisterEmailFragment
import com.example.instaapp.register.view.nameAndPassword.RegisterNamePasswordFragment

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterEmailFragment()
        replaceFragment(fragment)
    }

    override fun goToNameAndPasswordScreen(email: String) {
        val bundle = Bundle()
        bundle.putString(KEY_EMAIL, email)

        val fragment = RegisterNamePasswordFragment().apply {
            arguments = bundle
        }

        replaceFragment(fragment)
    }

    override fun goToWelcomeScreen(name: String) {
        val bundle = Bundle()
        bundle.putString(KEY_NAME, name)

        val fragment = RegisterWelcomeFragment().apply {
            arguments = bundle
        }

        replaceFragment(fragment)
    }

    override fun goToScreenPhoto() {
        replaceFragment(RegisterAddPhotosFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(R.id.register_fragment) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.register_fragment, fragment)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.register_fragment, fragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}