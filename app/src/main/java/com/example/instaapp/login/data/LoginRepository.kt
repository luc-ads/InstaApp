package com.example.instaapp.login.data

class LoginRepository(private val dataSource: LoginDataSource) {
    fun login(email: String, password: String) = dataSource.login(email, password)

}