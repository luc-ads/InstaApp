package com.example.instaapp.profile.data

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.instaapp.R
import com.example.instaapp.commom.base.RequestCallBack
import com.example.instaapp.commom.model.Database
import com.example.instaapp.commom.model.Post
import com.example.instaapp.commom.model.UserAuth

class ProfileFakeRemoteDataSource(private val context: Context): ProfileDataSource {
    override fun fetchUserProfile(uuid: String, callBack: RequestCallBack<UserAuth>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { uuid == it.uuid }

            if (userAuth != null) {
                callBack.onSuccess(userAuth)
            } else {
                callBack.onFailure(context.getString(R.string.user_not_found))
            }
            callBack.onComplete()
        }, 2000)
    }

    override fun fetchUserPosts(uuid: String, callBack: RequestCallBack<List<Post>>) {

        Handler(Looper.getMainLooper()).postDelayed({

            val userPosts = Database.posts[uuid]

            callBack.onSuccess(userPosts?.toList() ?: emptyList())
            callBack.onComplete()

        }, 2000)
    }
}