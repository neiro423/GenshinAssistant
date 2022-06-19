package com.saize.genshinassistant.fragments.calculator_party_buffs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentCalculatorPartyBuffsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorPartyBuffsFragment : BaseFragment<FragmentCalculatorPartyBuffsBinding>() {

    override val viewModel: CalculatorPartyBuffsViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalculatorPartyBuffsBinding.inflate(inflater, container, false)
}