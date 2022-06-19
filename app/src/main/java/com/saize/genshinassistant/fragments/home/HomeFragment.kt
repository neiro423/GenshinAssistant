package com.saize.genshinassistant.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.ToolbarConfig
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentHomeBinding
import com.saize.genshinassistant.util.mainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.updateToolbar(
            ToolbarConfig(
                "Home",
                backButtonEnabled = false
            )
        )
        viewModel.loadData()
    }
}