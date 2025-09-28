package com.iamelattar.blquraan.features.quraan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamelattar.blquraan.features.quraan.domain.usecases.GetAllSurahesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val getAllSurahesUseCase: GetAllSurahesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(SurahScreenState())
    val state: StateFlow<SurahScreenState> = _state
    private val intentFlow = MutableSharedFlow<SurahScreenAction>()


    init {
        handleAction()
        sendAction(SurahScreenAction.LoadSurahes)
    }

    fun sendAction(action: SurahScreenAction) =
        viewModelScope.launch {
            intentFlow.emit(action)

        }


    private fun handleAction() = viewModelScope.launch {
        intentFlow.collect { action ->
            when (action) {
                is SurahScreenAction.LoadSurahes -> loadSurahes()
                is SurahScreenAction.SearchSurah -> {}
                is SurahScreenAction.SelectSurah -> {}
            }
        }

    }

    private fun loadSurahes() = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true, error = null)
        val result = getAllSurahesUseCase()
        _state.value = result.fold(
            onSuccess = {
                _state.value.copy(
                    isLoading = false,
                    surahList = it, error = null
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