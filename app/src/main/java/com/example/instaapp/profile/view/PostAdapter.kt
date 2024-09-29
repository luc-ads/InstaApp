package com.example.instaapp.profile.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.commom.model.Post
import com.example.instaapp.databinding.ItemProfileGridBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    var posts: List<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            ItemProfileGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = 21

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    inner class PostViewHolder(private var itemBinding: ItemProfileGridBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(itemPost: Post) {
            itemBinding.itemProfileImgGrid.setImageURI(itemPost.uri)
        }
    }
}