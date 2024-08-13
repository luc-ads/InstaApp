package com.example.instaapp.login.presentation

import android.util.Patterns
import com.example.instaapp.R
import com.example.instaapp.login.LoginInterface

class LoginPresenter(
    private var view: LoginInterface.View?
): LoginInterface.Presenter {
    override fun login(email: String, password: String) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (password.length < 8) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }
    }

    override fun onDestroy() {
        view = null
    }
}