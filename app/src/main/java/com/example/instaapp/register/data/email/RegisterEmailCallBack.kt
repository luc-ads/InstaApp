package com.example.instaapp.register.data.email

interface RegisterEmailCallBack {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}