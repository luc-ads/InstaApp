package com.example.instaapp

import android.os.Bundle
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.instaapp.camera.CameraFragment
import com.example.instaapp.commom.util.replaceFragment
import com.example.instaapp.databinding.ActivityMainBinding
import com.example.instaapp.main.view.FeedFragment
import com.example.instaapp.profille.view.ProfileFragment
import com.example.instaapp.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: FeedFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var cameraFragment: CameraFragment
    private lateinit var profileFragment: ProfileFragment
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.insetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
        window.statusBarColor = ContextCompat.getColor(
            this,
            R.color.gray
        )

        initFragments()

        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_insta_camera)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    private fun initFragments() {
        homeFragment = FeedFragment()
        searchFragment = SearchFragment()
        cameraFragment = CameraFragment()
        profileFragment = ProfileFragment()

        currentFragment = homeFragment
        supportFragmentManager.beginTransaction().apply {
            add(R.id.main_fragment, homeFragment)
            commit()
        }

        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_bottom_home -> {
                    if (currentFragment == homeFragment) return@setOnItemSelectedListener false
                    currentFragment = homeFragment
                }
                R.id.menu_bottom_search -> {
                    if (currentFragment == searchFragment) return@setOnItemSelectedListener false
                    currentFragment = searchFragment
                }
                R.id.menu_bottom_add -> {
                    if (currentFragment == cameraFragment) return@setOnItemSelectedListener false
                    currentFragment = cameraFragment
                }
                R.id.menu_bottom_profile -> {
                    if (currentFragment == profileFragment) return@setOnItemSelectedListener false
                    currentFragment = profileFragment
                }
            }

            currentFragment?.let {
                replaceFragment(id = R.id.main_fragment, it)
            }

            return@setOnItemSelectedListener true
        }
    }
}