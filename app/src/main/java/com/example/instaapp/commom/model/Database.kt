package com.example.instaapp.commom.model

import java.util.UUID

object Database {

    val usersAuth = hashSetOf<UserAuth>()

    var sessionAuth: UserAuth? = null

    init {
        usersAuth.add(UserAuth(UUID.randomUUID().toString(), "a@a.com", "12345678"))
        usersAuth.add(UserAuth(UUID.randomUUID().toString(), "b@b.com", "12345678"))
    }

}