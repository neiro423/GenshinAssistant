package com.saize.genshinassistant.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saize.genshinassistant.util.ViewEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _eventFlow = MutableSharedFlow<ViewEvent>()
    val eventFlow: SharedFlow<ViewEvent> get() = _eventFlow

    fun pushViewEvent(viewEvent: ViewEvent) {
        viewModelScope.launch { _eventFlow.emit(viewEvent) }
    }
}