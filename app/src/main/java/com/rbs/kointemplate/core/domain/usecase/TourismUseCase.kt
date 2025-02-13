package com.rbs.kointemplate.core.domain.usecase

import com.rbs.kointemplate.core.data.source.Resource
import com.rbs.kointemplate.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}