package com.example.instaapp.register.data

interface RegisterCallBack {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}