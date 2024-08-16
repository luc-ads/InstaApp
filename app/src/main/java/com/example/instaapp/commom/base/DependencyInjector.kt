package com.example.instaapp.commom.base

import com.example.instaapp.login.LoginInterface
import com.example.instaapp.login.data.FakeDataSource
import com.example.instaapp.login.data.LoginRepository
import com.example.instaapp.login.presentation.LoginPresenter

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}