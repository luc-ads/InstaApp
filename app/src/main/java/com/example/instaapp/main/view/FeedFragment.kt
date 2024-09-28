package com.example.instaapp.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.R
import com.example.instaapp.commom.model.Database
import com.example.instaapp.commom.util.openCommentsModal
import com.example.instaapp.databinding.ItemPostListBinding
import com.example.instaapp.main.model.Posts

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRv(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profiile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun openModalComments() {
        //requireActivity().openCommentsModal()
        Log.i("Teste", "Teste")
    }

    private fun configRv(view: View) {
        val rv = view.findViewById<RecyclerView>(R.id.feed_rv)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter =
            PostAdapter(listPosts = Database.postsList, onClickComments = { openModalComments() })
    }

    private class PostAdapter(private val listPosts: List<Posts>, val onClickComments: () -> Unit) :
        RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

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

        private class PostViewHolder(private val itemBinding: ItemPostListBinding) :
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
}