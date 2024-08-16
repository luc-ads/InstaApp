package com.example.instaapp.login

import androidx.annotation.StringRes
import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface LoginInterface {

    interface Presenter: BasePresenter {
        fun login(email: String, password: String)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}