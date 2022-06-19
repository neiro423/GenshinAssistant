package com.saize.genshinassistant.fragments.home

import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.saize.genshinassistant.base.BaseViewModel
import com.saize.genshinassistant.domain.GetCharacterCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharacterCase: GetCharacterCase
) : BaseViewModel() {

    fun loadData() {
        viewModelScope.launch {
            getCharacterCase.execute("Хуеплет")
                .also { character ->
                    character ?: return@also
                    pushViewEvent {
                        Toast.makeText(
                            it.requireContext(), """
                                ${character.artifacts?.toList()}
                                ${character.name}
                                ${character.customName}
                            """, Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }
}