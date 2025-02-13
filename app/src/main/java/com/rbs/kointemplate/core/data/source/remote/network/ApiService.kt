package com.rbs.kointemplate.core.data.source.remote.network

import com.rbs.kointemplate.core.data.source.remote.model.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse
}