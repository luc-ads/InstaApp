package com.example.instaapp.register.presentation

import com.example.instaapp.register.data.nameAndPassword.RegisterNameAndPasswordCallBack
import com.example.instaapp.register.data.nameAndPassword.RegisterNameAndPasswordRepository
import com.example.instaapp.register.view.nameAndPassword.RegisterNameAndPassword

class RegisterNameAndPasswordPresenter(
    private var view: RegisterNameAndPassword.View?,
    private val repository: RegisterNameAndPasswordRepository
): RegisterNameAndPassword.Presenter {

    override fun create(name: String, password: String, confirm: String) {

        var isNameAndPassword = true
        if (isNameAndPassword) {
            view?.showProgress(true)

            repository.create(name, password, object : RegisterNameAndPasswordCallBack {
                override fun onSucess() {
                    view?.onCreateSuccess(name)
                }

                override fun onFailure(message: String) {
                    view?.onCreateFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }
            })
        } else {

        }
    }

    override fun onDestroy() {
        view = null
    }

}