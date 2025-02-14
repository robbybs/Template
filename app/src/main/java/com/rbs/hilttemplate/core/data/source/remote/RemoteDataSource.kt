package com.rbs.hilttemplate.core.data.source.remote

import android.util.Log
import com.rbs.hilttemplate.core.data.source.remote.model.TourismResponse
import com.rbs.hilttemplate.core.data.source.remote.network.ApiResponse
import com.rbs.hilttemplate.core.data.source.remote.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    companion object {
        private const val TAG = "RemoteDataSource"
    }
    suspend fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> = flow {
        try {
            val response = apiService.getList()
            val data = response.places
            if (data.isNotEmpty()){
                emit(ApiResponse.Success(data))
                Log.d(TAG, data.toString())
            } else {
                emit(ApiResponse.Error(response.message))
                Log.e(TAG, response.message)
            }
        } catch (exception : Exception){
            emit(ApiResponse.Error(exception.toString()))
            Log.e(TAG, exception.toString())
        }
    }.flowOn(Dispatchers.IO)
}