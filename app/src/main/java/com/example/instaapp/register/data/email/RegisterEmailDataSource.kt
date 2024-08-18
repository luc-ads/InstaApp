package com.example.instaapp.register.data.email

interface RegisterEmailDataSource {
    fun create(email: String, callBack: RegisterEmailCallBack)
}