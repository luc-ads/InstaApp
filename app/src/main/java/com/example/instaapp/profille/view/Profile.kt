package com.example.instaapp.profille.view

import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface Profile {

    interface Presenter: BasePresenter {
        fun fetchUserProfile()
        fun fetchUserPosts()
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
    }
}