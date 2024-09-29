package com.example.instaapp.commom.base

interface RequestCallBack<T> {

    fun onSuccess(data: T)
    fun onFailure(message: String)
    fun onComplete()
}