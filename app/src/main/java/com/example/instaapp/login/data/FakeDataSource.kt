package com.example.instaapp.login.data

import android.os.Looper
import com.example.instaapp.commom.model.Database
import java.util.logging.Handler

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callBack: LoginCallBack) {

        android.os.Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callBack.onFailure("Usuário não encontrado")
            } else if (password != userAuth.password) {
                callBack.onFailure("Senha incorreta")
            } else {
                Database.sessionAuth = userAuth
                callBack.onSucess(userAuth)
            }

            callBack.onComplete()
        }, 2000)
    }
}