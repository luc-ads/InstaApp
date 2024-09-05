package com.example.instaapp.commom.base

import com.example.instaapp.login.data.FakeDataSource
import com.example.instaapp.login.data.LoginRepository
import com.example.instaapp.register.data.FakeRegisterDataSource
import com.example.instaapp.register.data.RegisterRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }
}