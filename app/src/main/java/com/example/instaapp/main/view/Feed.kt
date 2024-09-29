package com.example.instaapp.main.view

import com.example.instaapp.commom.base.BasePresenter
import com.example.instaapp.commom.base.BaseView

interface Feed {

    interface Presenter: BasePresenter {

    }

    interface View: BaseView<Presenter> {

    }

}