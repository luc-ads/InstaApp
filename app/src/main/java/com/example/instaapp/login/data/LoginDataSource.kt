package com.example.instaapp.login.data

interface LoginDataSource {
    fun login(email: String, password: String, callBack: LoginCallBack)
}
