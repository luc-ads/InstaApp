package com.example.instaapp.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.R
import com.example.instaapp.databinding.ItemPostListBinding
import com.example.instaapp.commom.model.Post

 class FeedAdapter(private val listPosts: List<Post>, val onClickComments: () -> Unit) :
    RecyclerView.Adapter<FeedAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            ItemPostListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = listPosts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(
            image = R.drawable.ic_insta_add,
            lyricsPost = listPosts[position].title
        ) { onClickComments }
    }

    inner class PostViewHolder(itemBinding: ItemPostListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        val titlePost = itemBinding.homeTxtCaption
        val iconComments = itemBinding.iconComments

        fun bind(image: Int, lyricsPost: String, onClickComments: () -> Unit) {
            titlePost.text = lyricsPost
            iconComments.setOnClickListener {
                onClickComments.invoke()
            }
        }
    }
}