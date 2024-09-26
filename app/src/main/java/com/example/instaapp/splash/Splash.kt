package com.example.instaapp.splash

import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface Splash {

    interface Presenter : BasePresenter {
        fun authenticated()
    }

    interface View : BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()
    }

}