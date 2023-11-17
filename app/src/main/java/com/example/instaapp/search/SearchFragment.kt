package com.example.instaapp.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.R
import com.example.instaapp.databinding.ItemPostListBinding
import com.example.instaapp.databinding.ItemProfileGridBinding
import com.example.instaapp.databinding.ItemUserListBinding

class SearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
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

    private fun configRv(view: View) {
        val rv = view.findViewById<RecyclerView>(R.id.search_rv)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = SearchAdapter()
    }


    private class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
            val binding = ItemUserListBinding.inflate(LayoutInflater.from(parent.context),parent, false)

            return SearchViewHolder(binding)
        }

        override fun getItemCount(): Int = 21

        override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
            holder.bind(R.drawable.ic_insta_add)
            Log.i("onBindCall", "Passou pelo onBind")
        }

        private class SearchViewHolder(var itemBinding: ItemUserListBinding): RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(image: Int) {
//                itemBinding.root.setImageResource(image)
            }
        }
    }
}