package com.iamelattar.blquraan.features.quraan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamelattar.blquraan.features.quraan.domain.usecases.GetAllJuzUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JuzViewModel @Inject constructor(
    private val getAllJuzUseCase: GetAllJuzUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(JuzScreenState())
    val state: StateFlow<JuzScreenState> = _state
    private val initFlow = MutableSharedFlow<JuzScreenAction>()

    init {
        handleAction()
        sendAction(JuzScreenAction.LoadJuz)
    }

    private fun handleAction() {
        viewModelScope.launch {
            initFlow.collect { action ->
                when (action) {
                    is JuzScreenAction.LoadJuz -> loadJuz()
                    is JuzScreenAction.SelectJuz -> {}
                }
            }
        }
    }

    fun sendAction(action: JuzScreenAction) {
        viewModelScope.launch {
            initFlow.emit(action)
        }
    }

    private fun loadJuz() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            val result = getAllJuzUseCase()
            _state.value = result.fold(
                onSuccess = {
                    _state.value.copy(
                        isLoading = false,
                        juzList = it, error = null
                    )
                },
                onFailure = {
                    _state.value.copy(
                        isLoading = false,
                        error = it.message ?: "Unexpected error"
                    )
                }
            )
        }
    }
}
