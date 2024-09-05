package com.example.instaapp.register.data

interface RegisterDataSource {
    fun create(email: String, callBack: RegisterCallBack)
    fun create(email: String, name: String, password: String, callBack: RegisterCallBack)
}