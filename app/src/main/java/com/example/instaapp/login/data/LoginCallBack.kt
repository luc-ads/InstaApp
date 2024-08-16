package com.example.instaapp.login.data

import com.example.instaapp.commom.model.UserAuth

interface LoginCallBack {
    fun onSucess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}
