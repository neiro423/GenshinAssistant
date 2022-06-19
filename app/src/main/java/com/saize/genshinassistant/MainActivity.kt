package com.saize.genshinassistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.saize.genshinassistant.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    fun updateToolbar(toolbarConfig: ToolbarConfig) {
        binding.toolbar.apply {
            title = toolbarConfig.title
            navigationIcon = when (toolbarConfig.backButtonEnabled) {
                true -> ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.ic_toolbar_arrow_back
                )
                false -> null
            }
            setNavigationOnClickListener { onBackPressed() }
            binding.settingsButton.isVisible = toolbarConfig.additionalButtonParams != null
            toolbarConfig.additionalButtonParams ?: return
            binding.settingsButton.setImageResource(toolbarConfig.additionalButtonParams.iconId)
            binding.settingsButton.setOnClickListener {
                toolbarConfig.additionalButtonParams.onClickAction.invoke(this@MainActivity)
            }
        }
    }

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