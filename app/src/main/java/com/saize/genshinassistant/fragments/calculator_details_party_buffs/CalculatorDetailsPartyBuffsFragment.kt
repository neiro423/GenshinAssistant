package com.saize.genshinassistant.fragments.calculator_details_party_buffs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorDetailsPartyBuffsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorDetailsPartyBuffsFragment : BaseFragment<FragmentCalculatorDetailsPartyBuffsBinding>() {

    override val viewModel: CalculatorDetailsPartyBuffsViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorDetailsPartyBuffsBinding.inflate(inflater, container, false)
}