package com.rbs.kointemplate.core.data.source.local

import com.rbs.kointemplate.core.data.source.local.model.TourismEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val tourismDao: TourismDao) {
    fun getAllTourism(): Flow<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }
}