package com.example.instaapp.register.data

import com.example.instaapp.commom.model.UserAuth

interface RegisterEmailCallBack {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}