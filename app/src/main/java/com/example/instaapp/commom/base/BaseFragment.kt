package com.example.instaapp.commom.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<T, P : BasePresenter>(
    layoutId: Int,
    val bind: (View) -> T
    ) : Fragment(layoutId) {

    protected var binding: T? = null
    abstract var presenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = bind(view)
        setUpViews()
    }

    abstract fun setUpViews()
}