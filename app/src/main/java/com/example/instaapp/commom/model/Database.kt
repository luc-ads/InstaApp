package com.example.instaapp.commom.model

import java.util.UUID

object Database {

    //val postsList = mutableListOf<Post>(
    //   Post(
    //        uuid = "23",
    //        timeStamp = ,
    //        title = "Final de semana top com os amigos",
    //        comments = listOf("Essa foto ficou top", "Nem chamou pra esse role", "Tá bonitao hein")
    //    ),
    //    Post(
    //        title = "Nao é quinta mas tem TBT",
    //        comments = listOf("Esse dia foi muito top", "Quando vamos marcar o proximo hein")
    //    )
    //)

    val usersAuth = hashSetOf<UserAuth>()
    var sessionAuth: UserAuth? = null
    val posts = hashMapOf<String, Set<Post>>()

    init {
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"Luc", "a@a.com", "12345678"))
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"Luc", "b@b.com", "12345678"))

        sessionAuth = usersAuth.first()
    }
}