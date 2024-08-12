package com.example.instaapp.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.instaapp.commom.util.TxtWatcher
import com.example.instaapp.databinding.ActivityLoginBinding
import com.example.instaapp.login.LoginInterface
import com.example.instaapp.register.RegisterActivity


class LoginActivity : AppCompatActivity(), LoginInterface.View {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
    }

    private fun initValues() {
        with(binding) {
            edtEmail.addTextChangedListener(watcher)
            edtPassword.addTextChangedListener(watcher)
            btnLogin.setOnClickListener {


//                Handler(Looper.getMainLooper()).postDelayed({
//                    btnLogin.showProgress(false)
//                }, 2000)
            }

            txtCreateAccount.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }

    private val watcher = TxtWatcher {
        binding.btnLogin.isEnabled = it.isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.btnLogin.showProgress(true)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.edtLayoutEmail.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.edtLayoutPassword.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        // Go to Home Screen (Feed)
    }

    override fun onUserUnauthorized(message: String) {
        // Show Alert Error
    }
}