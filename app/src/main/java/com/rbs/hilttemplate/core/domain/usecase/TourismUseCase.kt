package com.rbs.hilttemplate.core.domain.usecase

import com.rbs.hilttemplate.core.data.source.Resource
import com.rbs.hilttemplate.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}