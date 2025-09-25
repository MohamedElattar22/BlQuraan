package com.iamelattar.blquraan.features.quraan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamelattar.blquraan.features.quraan.domain.SurahRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahRepo: SurahRepo
) : ViewModel() {
    private val _state = MutableStateFlow<SurahScreenState>(SurahScreenState.Loading)
    val state: StateFlow<SurahScreenState> = _state
    private val intentFlow = MutableSharedFlow<SurahScreenAction>()

    init {
        handleAction()
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
        _state.value = SurahScreenState.Loading
        try {
            val result = surahRepo.getAllSurahes()
            _state.value = result.fold(
                onSuccess = { SurahScreenState.Success(it) },
                onFailure = { SurahScreenState.Error(it.message ?: "Error loading data") }
            )
        } catch (e: Exception) {
            _state.value = SurahScreenState.Error(e.message ?: "Unknown Error")
        }


    }
}




