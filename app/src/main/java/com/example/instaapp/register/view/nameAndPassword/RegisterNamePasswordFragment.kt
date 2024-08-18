package com.example.instaapp.register.view.nameAndPassword

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.commom.util.TxtWatcher
import com.example.instaapp.databinding.FragmentRegisterNamePasswordBinding

class RegisterNamePasswordFragment: Fragment(R.layout.fragment_register_name_password), RegisterNameAndPassword.View {

    private var binding: FragmentRegisterNamePasswordBinding? = null

    override lateinit var presenter: RegisterNameAndPassword.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterNamePasswordBinding.bind(view)

        val email = arguments?.getString(KEY_EMAIL)

        binding?.let {
            addTextWatchers()

            with(it) {
                txtAlreadyLogin.setOnClickListener {
                    activity?.finish()
                }
                btnNextStepNamePassword.setOnClickListener {
                    presenter.create(edtName.text.toString(), edtPassword.text.toString(), edtPasswordConfirm.text.toString())
                }
            }
        }
    }

    private fun addTextWatchers() {
        binding.let {
            it?.edtName?.addTextChangedListener(watcher)
            it?.edtName?.addTextChangedListener(TxtWatcher{
                displayNameFailure(null)
            })

            it?.edtPassword?.addTextChangedListener(watcher)
            it?.edtPassword?.addTextChangedListener(TxtWatcher{
                displayPasswordFailure(null)
            })

            it?.edtPasswordConfirm?.addTextChangedListener(watcher)
            it?.edtPasswordConfirm?.addTextChangedListener(TxtWatcher{
                displayPasswordFailure(null)
            })
        }
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.btnNextStepNamePassword?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
        binding?.edtName?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding?.edtPassword?.error = passwordError?.let { getString(it) }
    }

//    override fun displayNameAndPasswordFailure(nameError: Int?, passwordError: Int?) {
//        if (nameError != null) {
//            binding?.edtName?.error = getString(nameError)
//        }
//        if (passwordError != null) {
//            binding?.edtPassword?.error = getString(passwordError)
//        }
//    }

    override fun onCreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateSuccess(name: String) {
        TODO("Not yet implemented")
    }

    override fun passwordDivergent(confirmPasswordError: Int?) {
        binding?.edtPassword?.error = confirmPasswordError?.let { getString(it) }
        binding?.edtPasswordConfirm?.error = confirmPasswordError?.let { getString(it) }
    }

    private val watcher = TxtWatcher {
        binding?.let {
            with(it) {
                btnNextStepNamePassword.isEnabled = it.edtName.text.toString().isNotEmpty()
                    && it.edtPassword.text.toString().isNotEmpty()
                    && it.edtPasswordConfirm.text.toString().isNotEmpty()
            }
        }
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }
}