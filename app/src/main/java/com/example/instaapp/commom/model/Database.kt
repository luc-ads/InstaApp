package com.example.instaapp.commom.model

import com.example.instaapp.main.model.Posts
import java.util.UUID

object Database {

    val postsList = mutableListOf<Posts>(
        Posts(
            title = "Final de semana top com os amigos",
            comments = listOf("Essa foto ficou top", "Nem chamou pra esse role", "Tá bonitao hein")
        ),
        Posts(
            title = "Nao é quinta mas tem TBT",
            comments = listOf("Esse dia foi muito top", "Quando vamos marcar o proximo hein")
        )
    )

    val usersAuth = hashSetOf<UserAuth>()
    var sessionAuth: UserAuth? = null

    init {
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"Luc", "a@a.com", "12345678"))
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"Luc", "b@b.com", "12345678"))

        sessionAuth = usersAuth.first()
    }
}