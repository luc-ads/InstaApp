package com.example.instaapp.login.presentation

import android.util.Patterns
import com.example.instaapp.R
import com.example.instaapp.login.LoginInterface
import com.example.instaapp.login.data.LoginCallBack
import com.example.instaapp.login.data.LoginRepository

class LoginPresenter(
    private var view: LoginInterface.View?,
    private val repository: LoginRepository
): LoginInterface.Presenter {
    override fun login(email: String, password: String) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        if (isEmailValid && isPasswordValid) {
            view?.showProgress(true)
            repository.login(email, password, object : LoginCallBack {
                override fun onSucess() {
                    view?.onUserAuthenticated()
                }

                override fun onFailure(message: String) {
                    view?.onUserUnauthorized(message)
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