package com.example.instaapp.register.data.nameAndPassword

interface RegisterNameAndPasswordDataSource {
    fun create(name: String, password: String, callBack: RegisterNameAndPasswordCallBack)
}