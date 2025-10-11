package com.iamelattar.blquraan.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()
    private val actionFlow = MutableSharedFlow<HomeScreenAction>()

    init {
        handleAction()
    }

    fun sendAction(action: HomeScreenAction) = viewModelScope.launch(Dispatchers.Main.immediate) {
        actionFlow.emit(action)
    }

    private fun handleAction() = viewModelScope.launch(Dispatchers.Main.immediate) {
        actionFlow.collect { action ->
            when (action) {
                is HomeScreenAction.LoadData -> {}
                HomeScreenAction.ResetError -> resetError()
            }
        }
    }

    private fun resetError() = _uiState.update { it.copy(error = null) }
}