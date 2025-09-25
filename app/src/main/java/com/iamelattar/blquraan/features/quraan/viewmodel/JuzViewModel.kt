package com.iamelattar.blquraan.features.quraan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamelattar.blquraan.features.quraan.domain.JuzRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JuzViewModel @Inject constructor(
    private val juzRepo: JuzRepo
) : ViewModel() {
    private val _state = MutableStateFlow<JuzScreenState>(JuzScreenState.Loading)
    val state: StateFlow<JuzScreenState> = _state.asStateFlow()

    init {
        fetchJuzList()
    }

    private fun fetchJuzList() {
        viewModelScope.launch {
            try {
                _state.value = JuzScreenState.Loading
                val result = juzRepo.getAllJuzs()
                _state.value = result.fold(
                    onSuccess = { JuzScreenState.Success(it) },
                    onFailure = { JuzScreenState.Error(it.message ?: "Error loading data") }
                )

            } catch (e: Exception) {
                _state.value = JuzScreenState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}