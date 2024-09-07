package com.example.instaapp.register.data

import android.os.Looper
import com.example.instaapp.commom.model.Database
import com.example.instaapp.commom.model.UserAuth
import java.util.UUID

class FakeRegisterDataSource : RegisterDataSource {
    override fun create(email: String, callBack: RegisterCallBack) {
        android.os.Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callBack.onSucess()
            } else {
                callBack.onFailure("Usuário já cadastrado")
            }

            callBack.onComplete()
        }, 2000)
    }

    override fun create(
        email: String,
        name: String,
        password: String,
        callBack: RegisterCallBack
    ) {
        android.os.Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth != null) {
                callBack.onFailure("Usuário já cadastrado!")
            } else {

                val newUser = UserAuth(
                    UUID.randomUUID().toString(),
                    name,
                    email,
                    password
                )

                val created = Database.usersAuth.add(
                    newUser
                )

                if (created) {
                    Database.sessionAuth = newUser
                    callBack.onSucess()
                } else {
                    callBack.onFailure("Erro interno no servidor.")
                }
            }
            callBack.onComplete()
        }, 2000)
    }
}