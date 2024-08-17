package com.example.instaapp.register.data

class RegisterEmailRepository(private val dataSource: FakeRegisterDataSource) {
    fun create(email: String, callBack: RegisterEmailCallBack) {
        dataSource.create(email, callBack)
    }
}