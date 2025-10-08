package com.iamelattar.blquraan.features.quraan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamelattar.blquraan.features.quraan.domain.usecases.GetAllSurahesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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
        _state.update { it.copy(isLoading = true, error = null) }
        getAllSurahesUseCase().fold(
            onSuccess = { suraList ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        surahList = suraList, error = null
                    )
                }
            },
            onFailure = { throwable ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = throwable.message ?: "Unexpected error"
                    )
                }
            }
        )
    }
}