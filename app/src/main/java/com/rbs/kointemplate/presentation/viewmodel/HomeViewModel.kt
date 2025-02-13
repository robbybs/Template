package com.rbs.kointemplate.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rbs.kointemplate.core.data.source.Resource
import com.rbs.kointemplate.core.domain.usecase.TourismUseCase
import com.rbs.kointemplate.presentation.viewstate.TourismViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: TourismUseCase) : ViewModel() {
    private var _viewState = MutableStateFlow(TourismViewState())
    val viewState = _viewState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _viewState.value = _viewState.value.copy(isLoading = true)
            useCase.getAllTourism().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _viewState.value = _viewState.value.copy(isLoading = true)
                    }
                    is Resource.Success -> {
                        _viewState.value = _viewState.value.copy(isLoading = false, data = result.data.orEmpty())
                    }
                    is Resource.Error -> {
                        _viewState.value = _viewState.value.copy(isLoading = false, data = emptyList())
                    }
                }
            }
        }
    }
}