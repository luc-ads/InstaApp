package com.example.instaapp.register.data.nameAndPassword

interface RegisterNameAndPasswordCallBack {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}
