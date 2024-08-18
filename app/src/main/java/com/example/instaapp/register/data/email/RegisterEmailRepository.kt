package com.example.instaapp.register.data.email

import com.example.instaapp.register.data.FakeRegisterDataSource

class RegisterEmailRepository(private val dataSource: FakeRegisterDataSource) {
    fun create(email: String, callBack: RegisterEmailCallBack) {
        dataSource.create(email, callBack)
    }
}