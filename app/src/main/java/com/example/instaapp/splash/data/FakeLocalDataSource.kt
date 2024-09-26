package com.example.instaapp.splash.data

import com.example.instaapp.commom.model.Database

class FakeLocalDataSource: SplashDataSource {
    override fun session(callBack: SplashCallBack) {
        if (Database.sessionAuth != null) {
            callBack.onSuccess()
        } else {
            callBack.onFailure()
        }
    }


}