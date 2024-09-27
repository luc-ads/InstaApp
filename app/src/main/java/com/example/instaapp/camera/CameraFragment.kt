package com.example.instaapp.camera

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
import com.example.instaapp.databinding.CameraFragmentBinding
import com.example.instaapp.databinding.ItemPostListBinding
import com.example.instaapp.databinding.ItemProfileGridBinding

class CameraFragment: Fragment() {

    private var binding: CameraFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CameraFragmentBinding.bind(view)
    }
}