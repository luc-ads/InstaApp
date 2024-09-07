package com.example.instaapp.register.view

interface FragmentAttachListener {
    fun goToNameAndPasswordScreen(email: String)
    fun goToWelcomeScreen(name: String)
    fun goToScreenPhoto()
    fun goToMainScreen()
}