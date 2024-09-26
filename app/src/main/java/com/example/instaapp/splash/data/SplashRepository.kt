package com.example.instaapp.splash.data

class SplashRepository(private val dataSource: SplashDataSource) {

    fun session(callBack: SplashCallBack) {
        dataSource.session(callBack)
    }
}