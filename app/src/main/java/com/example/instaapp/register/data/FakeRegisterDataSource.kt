package com.example.instaapp.register.data

import android.os.Looper
import com.example.instaapp.commom.model.Database
import java.util.logging.Handler

class FakeRegisterDataSource : RegisterEmailDataSource {
    override fun create(email: String, callBack: RegisterEmailCallBack) {
        android.os.Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callBack.onSucess()
            } else {
                callBack.onFailure("Usuário já cadastrado")
            }

            callBack.onComplete()
        },    2000) }
}