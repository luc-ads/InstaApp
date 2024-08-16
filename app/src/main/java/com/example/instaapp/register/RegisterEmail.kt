package com.example.instaapp.register

import androidx.annotation.StringRes
import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface RegisterEmail {

    interface Presenter: BasePresenter {
        fun create(email: String)
    }

    interface View: BaseView<Presenter> {
        fun displayEmailFailure(@StringRes emailError: Int?)
    }
}