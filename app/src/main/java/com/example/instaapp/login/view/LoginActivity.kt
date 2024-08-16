package com.example.instaapp.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instaapp.MainActivity
import com.example.instaapp.commom.base.DependencyInjector
import com.example.instaapp.commom.util.TxtWatcher
import com.example.instaapp.databinding.ActivityLoginBinding
import com.example.instaapp.login.LoginInterface
import com.example.instaapp.login.data.FakeDataSource
import com.example.instaapp.login.data.LoginRepository
import com.example.instaapp.login.presentation.LoginPresenter
import com.example.instaapp.register.RegisterActivity


class LoginActivity : AppCompatActivity(), LoginInterface.View {

    private lateinit var binding: ActivityLoginBinding
    override lateinit var presenter: LoginInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
    }

    private fun initValues() {

//        val repository = LoginRepository(FakeDataSource())
        presenter = LoginPresenter(this, DependencyInjector.loginRepository())

        with(binding) {
            edtEmail.addTextChangedListener(watcher)
            edtEmail.addTextChangedListener(TxtWatcher{
                displayEmailFailure(null)
            })
            edtPassword.addTextChangedListener(watcher)
            edtPassword.addTextChangedListener(TxtWatcher {
                displayPasswordFailure(null)
            })
            btnLogin.setOnClickListener {
                presenter.login(edtEmail.text.toString(), edtPassword.text.toString())
            }

            txtCreateAccount.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding.btnLogin.isEnabled =
            binding.edtEmail.text.toString().isNotEmpty() &&
                    binding.edtPassword.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.btnLogin.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.edtLayoutEmail.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.edtLayoutPassword.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }

    override fun onUserUnauthorized(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}