package com.rbs.kointemplate.presentation.viewstate

import com.rbs.kointemplate.core.domain.model.Tourism

data class TourismViewState(
    val isLoading: Boolean = false,
    val data: List<Tourism> = emptyList()
)
