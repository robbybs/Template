package com.rbs.kointemplate.utils

import com.rbs.kointemplate.core.data.source.remote.model.TourismResponse
import com.rbs.kointemplate.core.domain.model.Tourism

object Mapper {
    fun tourismDataToDomain(input: List<TourismResponse>): List<Tourism> {
        val tourismList = ArrayList<Tourism>()
        input.map {
            val tourism = Tourism(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }
}