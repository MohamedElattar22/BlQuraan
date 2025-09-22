package com.iamelattar.blquraan.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main.immediate
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    private val intentFlow = MutableSharedFlow<HomeScreenAction>()

    init {
        handleAction()
    }

    fun sendAction(action: HomeScreenAction) = viewModelScope.launch(dispatcher) {
        intentFlow.emit(action)
    }

    private fun handleAction() = viewModelScope.launch(dispatcher) {
        intentFlow.collect { action ->
            when (action) {
                is HomeScreenAction.LoadData -> doSomeNetworkRequests()
                HomeScreenAction.ResetError -> resetError()
            }
        }
    }

    private fun doSomeNetworkRequests() = viewModelScope.launch(dispatcher) {
        _uiState.update { it.copy(loading = true) }
        simulateUseCase().fold(
            onSuccess = { result ->
                _uiState.update { it.copy(hijriDate = result, loading = false) }
            },
            onFailure = { exception ->
                _uiState.update { it.copy(error = exception.message, loading = false) }
            }
        )
    }

    private suspend fun simulateUseCase(): Result<String> {
        return runCatching {
            withContext(Dispatchers.IO) {
                delay(3000)
            }
            "Mohamed is here"
        }
    }

    private fun resetError() = _uiState.update { it.copy(error = null) }
}
