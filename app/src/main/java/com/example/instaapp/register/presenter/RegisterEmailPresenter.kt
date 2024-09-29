package com.example.instaapp.register.presenter

import android.util.Patterns
import com.example.instaapp.R
import com.example.instaapp.register.data.RegisterCallBack
import com.example.instaapp.register.data.RegisterRepository
import com.example.instaapp.register.view.email.RegisterEmail

class RegisterEmailPresenter(
    private var view: RegisterEmail.View?,
    private val repository: RegisterRepository
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
            repository.create(email, object : RegisterCallBack {

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