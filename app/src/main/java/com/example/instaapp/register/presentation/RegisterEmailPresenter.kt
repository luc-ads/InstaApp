package com.example.instaapp.register.presentation

import android.util.Patterns
import com.example.instaapp.R
import com.example.instaapp.register.data.email.RegisterEmailCallBack
import com.example.instaapp.register.data.email.RegisterEmailRepository
import com.example.instaapp.register.view.email.RegisterEmail

class RegisterEmailPresenter(
    private var view: RegisterEmail.View?,
    private val repository: RegisterEmailRepository
): RegisterEmail.Presenter {
    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (isEmailValid) {
            view?.showProgress(true)
            repository.create(email, object : RegisterEmailCallBack {

                override fun onSucess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }
            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}