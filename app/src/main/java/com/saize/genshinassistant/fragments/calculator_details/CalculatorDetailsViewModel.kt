package com.saize.genshinassistant.fragments.calculator_details

import androidx.lifecycle.viewModelScope
import com.saize.genshinassistant.base.BaseViewModel
import com.saize.genshinassistant.domain.GetAllCharactersCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CalculatorDetailsViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharactersCase
) : BaseViewModel() {

    val allCharacters = getAllCharacters.execute()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}