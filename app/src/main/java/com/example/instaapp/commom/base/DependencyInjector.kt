package com.example.instaapp.commom.base

import com.example.instaapp.login.LoginInterface
import com.example.instaapp.login.data.FakeDataSource
import com.example.instaapp.login.data.LoginRepository
import com.example.instaapp.login.presentation.LoginPresenter
import com.example.instaapp.register.data.FakeRegisterDataSource
import com.example.instaapp.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterDataSource())
    }
}