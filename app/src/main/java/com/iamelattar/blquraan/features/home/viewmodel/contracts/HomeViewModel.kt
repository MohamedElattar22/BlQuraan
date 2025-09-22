package com.iamelattar.blquraan.features.home.viewmodel.contracts

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()


    fun onAction(action: HomeScreenAction) {
        when (action) {
            is HomeScreenAction.LoadData -> {}
            is HomeScreenAction.ContinueReadingClicked -> {}
            is HomeScreenAction.CopyAyahClicked -> {}
            is HomeScreenAction.OnFeatureClick -> TODO()
        }
    }

}
