package com.example.instaapp.register.data.nameAndPassword

class RegisterNameAndPasswordRepository(private val dataSource: RegisterNameAndPasswordDataSource) {
    fun create(name: String, password: String, callBack: RegisterNameAndPasswordCallBack) {
        dataSource.create(name, password, callBack)
    }
}