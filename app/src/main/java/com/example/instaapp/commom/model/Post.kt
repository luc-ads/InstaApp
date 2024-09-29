package com.example.instaapp.commom.model

import android.net.Uri

data class Post(
    val uuid: String,
    val uri: Uri,
    val caption: String,
    val timeStamp: Long,
    val comments: List<String>
)
