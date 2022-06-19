package com.saize.genshinassistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.saize.genshinassistant.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            setOnItemReselectedListener {
                navController.popBackStack(it.itemId, false)
            }
            setOnItemSelectedListener {
                it.onNavDestinationSelected(navController)
                true
            }
        }
    }
}