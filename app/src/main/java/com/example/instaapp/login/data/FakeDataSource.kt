package com.example.instaapp.login.data

import android.os.Looper
import java.util.logging.Handler

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callBack: LoginCallBack) {

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            if (email == "a@a.com" && password == "12345678") callBack.onSucess()
            else callBack.onFailure("Erro de login: usuário não encontrado")

        callBack.onComplete()
        }, 2000)

    }

}