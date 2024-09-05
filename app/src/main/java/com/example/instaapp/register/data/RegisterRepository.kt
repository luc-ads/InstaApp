package com.example.instaapp.register.data

class RegisterRepository(private val dataSource: FakeRegisterDataSource) {
    fun create(email: String, callBack: RegisterCallBack) {
        dataSource.create(email, callBack)
    }

    fun create(email: String, name: String, password: String, callBack: RegisterCallBack) {
        dataSource.create(email, name, password, callBack)
    }
}