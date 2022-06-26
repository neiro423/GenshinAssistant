package com.saize.genshinassistant.fragments.calculator_details_artifacts_add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorAddArtifactsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorDetailsArtifactsAddFragment : BaseFragment<FragmentCalculatorAddArtifactsBinding>() {

    override val viewModel: CalculatorDetailsArtifactsAddViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorAddArtifactsBinding.inflate(inflater, container, false)
}