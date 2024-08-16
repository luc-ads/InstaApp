package com.example.instaapp.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaapp.R
import com.example.instaapp.commom.util.TxtWatcher
import com.example.instaapp.databinding.FragmentRegisterEmailBinding

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    private var binding: FragmentRegisterEmailBinding? = null

    override lateinit var presenter: RegisterEmail.Presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterEmailBinding.bind(view)

        binding?.let {
            with(it) {
                txtCreateAccount.setOnClickListener {
                    activity?.finish()
                }

                btnNextStep.setOnClickListener {
                    presenter.create(edtEmail.text.toString())
                }

                edtEmail.addTextChangedListener(watcher)
                edtEmail.addTextChangedListener(TxtWatcher{
                    displayEmailFailure(null)
                })
            }
        }
    }

    override fun displayEmailFailure(emailError: Int?) {

    }

    override fun onDestroy() {
        binding = null
//        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding?.let {
            with(it) {
                btnNextStep.isEnabled = it.edtEmail.text.toString().isNotEmpty()
            }
        }
    }
}