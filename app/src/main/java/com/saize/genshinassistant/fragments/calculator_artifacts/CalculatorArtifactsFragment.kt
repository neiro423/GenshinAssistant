package com.saize.genshinassistant.fragments.calculator_artifacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorArtifactsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorArtifactsFragment : BaseFragment<FragmentCalculatorArtifactsBinding>() {

    override val viewModel: CalculatorArtifactsViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorArtifactsBinding.inflate(inflater, container, false)
}