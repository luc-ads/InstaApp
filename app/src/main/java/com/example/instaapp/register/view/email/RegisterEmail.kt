package com.example.instaapp.register.view.email

import androidx.annotation.StringRes
import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface RegisterEmail {

    interface Presenter: BasePresenter {
        fun create(email: String)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun onEmailFailure(message: String)
        fun goToNameAndPasswordScreen(email: String)
    }
}