package com.saize.genshinassistant.fragments.calculator_details_character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorDetailsCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorDetailsCharacterFragment : BaseFragment<FragmentCalculatorDetailsCharacterBinding>() {

    override val viewModel: CalculatorDetailsCharacterViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorDetailsCharacterBinding.inflate(inflater, container, false)
}