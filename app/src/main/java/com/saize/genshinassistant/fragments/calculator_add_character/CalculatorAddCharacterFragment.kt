package com.saize.genshinassistant.fragments.calculator_add_character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorAddCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorAddCharacterFragment : BaseFragment<FragmentCalculatorAddCharacterBinding>() {

    override val viewModel: CalculatorAddCharacterViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorAddCharacterBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}