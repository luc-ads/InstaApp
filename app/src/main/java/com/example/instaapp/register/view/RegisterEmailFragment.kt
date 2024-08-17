package com.example.instaapp.register.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.commom.base.DependencyInjector
import com.example.instaapp.commom.util.TxtWatcher
import com.example.instaapp.databinding.FragmentRegisterEmailBinding
import com.example.instaapp.register.presentation.RegisterEmailPresenter

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    private var binding: FragmentRegisterEmailBinding? = null

    override lateinit var presenter: RegisterEmail.Presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterEmailBinding.bind(view)

        presenter = RegisterEmailPresenter(this, DependencyInjector.registerEmailRepository())

        binding?.let {
            with(it) {
                txtCreateAccount.setOnClickListener {
                    activity?.finish()
                }

                btnNextStep.setOnClickListener {
                    presenter.create(edtEmail.text.toString())
                }

                edtEmail.addTextChangedListener(watcher)
                edtEmail.addTextChangedListener(TxtWatcher{
                    displayEmailFailure(null)
                })
            }
        }
    }

    override fun showProgress(enabled: Boolean) {
        binding?.btnNextStep?.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding?.edtEmail?.error = emailError?.let { getString(it) }
    }

    override fun onEmailFailure(message: String) {
        binding?.edtEmail?.error = message
    }

    override fun goToNameAndPasswordScreen(email: String) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding?.let {
            with(it) {
                btnNextStep.isEnabled = it.edtEmail.text.toString().isNotEmpty()
            }
        }
    }
}