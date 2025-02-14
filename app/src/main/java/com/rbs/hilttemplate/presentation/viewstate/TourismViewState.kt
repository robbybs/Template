package com.rbs.hilttemplate.presentation.viewstate

import com.rbs.hilttemplate.core.domain.model.Tourism

data class TourismViewState(
    val isLoading: Boolean = false,
    val data: List<Tourism> = emptyList()
)
