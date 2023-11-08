package com.example.instaapp.profille.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.R
import com.example.instaapp.databinding.ItemProfileGridBinding

class ProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRv(view)
    }

    private fun configRv(view: View) {
        val rv = view.findViewById<RecyclerView>(R.id.profile_rv)
        rv.layoutManager = GridLayoutManager(requireContext(), 3)
        rv.adapter = PostAdapter()
    }


    private class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val binding = ItemProfileGridBinding.inflate(LayoutInflater.from(parent.context),parent, false)

            return PostViewHolder(binding)
        }

        override fun getItemCount(): Int = 21

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            holder.bind(R.drawable.ic_insta_add)
            Log.i("onBindCall", "Passou pelo onBind")
        }

        private class PostViewHolder(var itemBinding: ItemProfileGridBinding): RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(image: Int) {
                itemBinding.itemProfileImgGrid.setImageResource(image)
            }
        }
    }
}