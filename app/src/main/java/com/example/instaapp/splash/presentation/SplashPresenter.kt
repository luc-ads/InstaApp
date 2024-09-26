package com.example.instaapp.splash.presentation

import com.example.instaapp.splash.Splash
import com.example.instaapp.splash.data.SplashCallBack
import com.example.instaapp.splash.data.SplashRepository

class SplashPresenter(
    private var view: Splash.View?,
    private val repository: SplashRepository
): Splash.Presenter {
    override fun authenticated() {
        repository.session(object : SplashCallBack {
            override fun onSuccess() {
                view?.goToMainScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}