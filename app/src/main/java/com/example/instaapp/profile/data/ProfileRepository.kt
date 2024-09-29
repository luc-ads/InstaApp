package com.example.instaapp.profile.data

import com.example.instaapp.commom.base.RequestCallBack
import com.example.instaapp.commom.model.Post
import com.example.instaapp.commom.model.UserAuth

class ProfileRepository(private val dataSource: ProfileDataSource) {
    fun fetchUserProfile(uuid: String, callBack: RequestCallBack<UserAuth>) {
        dataSource.fetchUserProfile(uuid, callBack)
    }

    fun fetchUserPosts(uuid: String, callBack: RequestCallBack<List<Post>>) {
        dataSource.fetchUserPosts(uuid, callBack)
    }
}