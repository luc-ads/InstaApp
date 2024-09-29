package com.example.instaapp.profile.data

import com.example.instaapp.commom.base.RequestCallBack
import com.example.instaapp.commom.model.Post
import com.example.instaapp.commom.model.UserAuth

interface ProfileDataSource {

    fun fetchUserProfile(uuid: String, callBack: RequestCallBack<UserAuth>)
    fun fetchUserPosts(uuid: String, callBack: RequestCallBack<List<Post>>)
}