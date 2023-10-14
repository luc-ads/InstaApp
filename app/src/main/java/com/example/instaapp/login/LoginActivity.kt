package com.example.instaapp.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.instaapp.databinding.ActivityLoginBinding
import com.example.instaapp.register.RegisterActivity


class LoginActivity : AppCompatActivity() {

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
                btnLogin.showProgress(true)

                edtLayoutEmail.error = "Esse email está incorreto"
                edtLayoutPassword.error = "Essea senha está incorreta"

                Handler(Looper.getMainLooper()).postDelayed({
                    btnLogin.showProgress(false)
                }, 2000)
            }

            txtCreateAccount.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }


    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.btnLogin.isEnabled = binding.edtEmail.text!!.isNotEmpty() && binding.edtPassword.text!!.isNotEmpty()
        }
        override fun afterTextChanged(s: Editable?) { }

    }
}