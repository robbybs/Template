package com.rbs.kointemplate.core.data.repository

import com.rbs.kointemplate.core.data.source.Resource
import com.rbs.kointemplate.core.data.source.remote.network.ApiResponse
import com.rbs.kointemplate.core.data.source.NetworkBoundResource
import com.rbs.kointemplate.core.data.source.local.LocalDataSource
import com.rbs.kointemplate.core.data.source.remote.RemoteDataSource
import com.rbs.kointemplate.core.data.source.remote.model.TourismResponse
import com.rbs.kointemplate.utils.Mapper
import com.rbs.kointemplate.core.domain.repository.ITourismRepository
import com.rbs.kointemplate.core.domain.model.Tourism
import com.rbs.kointemplate.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TourismRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors,
) : ITourismRepository {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            private var tourismList: List<Tourism> = emptyList()

            override fun loadData(): Flow<List<Tourism>> = flow { emit(tourismList) }

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun onFetchSuccess(data: List<TourismResponse>) {
                tourismList = Mapper.tourismDataToDomain(data)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> = flow {}

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {}
}