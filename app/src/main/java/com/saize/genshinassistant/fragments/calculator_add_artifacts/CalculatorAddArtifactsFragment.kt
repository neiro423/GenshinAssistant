package com.saize.genshinassistant.fragments.calculator_add_artifacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorAddArtifactsBinding
import com.saize.genshinassistant.fragments.calculator.CalculatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorAddArtifactsFragment : BaseFragment<FragmentCalculatorAddArtifactsBinding>() {

    override val viewModel: CalculatorAddArtifactsViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorAddArtifactsBinding.inflate(inflater, container, false)
}