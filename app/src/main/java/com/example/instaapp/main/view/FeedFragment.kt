package com.example.instaapp.main.view

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instaapp.R
import com.example.instaapp.commom.base.BaseFragment
import com.example.instaapp.commom.model.Database
import com.example.instaapp.databinding.FeedFragmentBinding

class FeedFragment : BaseFragment<FeedFragmentBinding, Feed.Presenter>(
    R.layout.feed_fragment,
    FeedFragmentBinding::bind
) {

    override lateinit var presenter: Feed.Presenter

    override fun setUpPresenter() { }

    override fun setUpViews() {
        binding?.feedRv?.layoutManager = LinearLayoutManager(requireContext())
        binding?.feedRv?.adapter =
            FeedAdapter(listPosts = Database.postsList, onClickComments = { openModalComments() })
    }

    override fun getMenu(): Int {
        return R.menu.menu_profiile
    }

    private fun openModalComments() { }
}