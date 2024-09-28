package com.example.instaapp.profille.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.R
import com.example.instaapp.commom.base.BaseFragment
import com.example.instaapp.databinding.ItemProfileGridBinding
import com.example.instaapp.databinding.ProfileFragmentBinding

class ProfileFragment: BaseFragment<ProfileFragmentBinding, Profile.Presenter>(R.layout.profile_fragment,
    ProfileFragmentBinding::bind) {

    override lateinit var presenter: Profile.Presenter

    override fun setUpViews() {
        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.profileRv?.adapter = PostAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profiile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
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