package com.rbs.hilttemplate.core.domain.repository

import com.rbs.hilttemplate.core.data.source.Resource
import com.rbs.hilttemplate.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}