package com.example.instaapp.register.view.nameAndPassword

import androidx.annotation.StringRes
import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface RegisterNameAndPassword {

    interface Presenter: BasePresenter {
        fun create(name: String, password: String, confirm: String)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayNameFailure(@StringRes nameError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onCreateFailure(message: String)
        fun onCreateSuccess(name: String)
        fun passwordDivergent(@StringRes confirmPasswordError: Int?)
    }
}