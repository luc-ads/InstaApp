package com.example.instaapp.profile.view

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instaapp.R
import com.example.instaapp.commom.base.BaseFragment
import com.example.instaapp.commom.model.Post
import com.example.instaapp.commom.model.UserAuth
import com.example.instaapp.databinding.ProfileFragmentBinding
import com.example.instaapp.profile.data.Profile

class ProfileFragment : BaseFragment<ProfileFragmentBinding, Profile.Presenter>(
    R.layout.profile_fragment,
    ProfileFragmentBinding::bind
), Profile.View {

    override lateinit var presenter: Profile.Presenter
    private val adapter = PostAdapter()

    override fun setUpPresenter() { }

    override fun setUpViews() {
        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.profileRv?.adapter = adapter

        presenter.fetchUserProfile()
    }

    override fun getMenu(): Int {
        return R.menu.menu_profiile
    }

    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.apply {
            profileTxtPostsCount.text = userAuth.postCount.toString()
            profileTxtFollowing.text = userAuth.followingCount.toString()
            profileTxtFollowers.text = userAuth.followersCount.toString()
            profileTxtUsername.text = userAuth.name
            profileTxtBio.text = "TODO"
        }
        presenter.fetchUserPosts()
    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun displayEmptyPosts() {
        binding?.apply {
            txtEmptyProfile.visibility = View.VISIBLE
            profileRv.visibility = View.GONE
        }
    }

    override fun displayFullPosts(posts: List<Post>) {
        binding?.apply {
            txtEmptyProfile.visibility = View.GONE
            profileRv.visibility = View.VISIBLE
            adapter.posts = posts
            adapter.notifyDataSetChanged()
        }
    }
}