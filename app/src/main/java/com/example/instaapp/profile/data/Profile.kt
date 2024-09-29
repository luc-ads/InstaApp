package com.example.instaapp.profile.data

import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView
import com.example.instaapp.commom.model.UserAuth
import com.example.instaapp.commom.model.Post

interface Profile {

    interface Presenter: BasePresenter {
        fun fetchUserProfile()
        fun fetchUserPosts()
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayUserProfile(userAuth: UserAuth)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }
}