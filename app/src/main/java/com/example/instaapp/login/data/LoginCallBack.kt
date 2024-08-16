package com.example.instaapp.login.data

interface LoginCallBack {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}
