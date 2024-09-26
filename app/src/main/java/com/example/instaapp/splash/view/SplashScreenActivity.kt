package com.example.instaapp.splash.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instaapp.MainActivity
import com.example.instaapp.commom.base.DependencyInjector
import com.example.instaapp.databinding.ActivitySplashScreenBinding
import com.example.instaapp.login.view.LoginActivity
import com.example.instaapp.splash.Splash
import com.example.instaapp.splash.presentation.SplashPresenter

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity(), Splash.View  {

    override lateinit var presenter: Splash.Presenter
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = DependencyInjector.splashRepository()
        presenter =  SplashPresenter(this, repository)

        binding.splashImg.animate().apply {
            setListener(object : AnimatorListenerAdapter() {
               override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    presenter.authenticated()
                }
            })
            duration = 1000
            alpha(1.0f)
            start()
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun goToMainScreen() {
        hideFadeIcon {
            startActivity(Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    override fun goToLoginScreen() {
        hideFadeIcon {
            startActivity(Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    private fun hideFadeIcon(callBack: () -> Unit) {
        binding.splashImg.animate().apply {
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    callBack.invoke()
                }
            })
            startDelay = 1000
            duration = 1000
            alpha(0.0f)
            start()
        }
    }
}