package com.saize.genshinassistant.fragments.calculator_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorDetailsFragment : BaseFragment<FragmentCalculatorDetailsBinding>() {

    override val viewModel: CalculatorDetailsViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorDetailsBinding.inflate(inflater, container, false)
}