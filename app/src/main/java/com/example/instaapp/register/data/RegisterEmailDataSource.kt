package com.example.instaapp.register.data

interface RegisterEmailDataSource {
    fun create(email: String, callBack: RegisterEmailCallBack)
}