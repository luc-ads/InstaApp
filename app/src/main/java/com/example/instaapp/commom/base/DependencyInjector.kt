package com.example.instaapp.commom.base

import com.example.instaapp.login.data.FakeDataSource
import com.example.instaapp.login.data.LoginRepository
import com.example.instaapp.register.data.FakeRegisterDataSource
import com.example.instaapp.register.data.RegisterRepository
import com.example.instaapp.splash.data.FakeLocalDataSource
import com.example.instaapp.splash.data.SplashDataSource
import com.example.instaapp.splash.data.SplashRepository

object DependencyInjector {
    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }
}