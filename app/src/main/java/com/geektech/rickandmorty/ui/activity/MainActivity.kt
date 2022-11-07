package com.geektech.rickandmorty.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.character_fragment -> setVisibilityNavBottom(true)
                R.id.episode_fragment -> setVisibilityNavBottom(true)
                R.id.location_fragment -> setVisibilityNavBottom(true)
                else -> setVisibilityNavBottom(false)
            }
        }
    }

    private fun setVisibilityNavBottom(isVisible: Boolean) {
        binding.bottomNavView.apply {
            visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }
}