package com.rbs.kointemplate.core.domain.interactor

import com.rbs.kointemplate.core.domain.repository.ITourismRepository
import com.rbs.kointemplate.core.domain.model.Tourism
import com.rbs.kointemplate.core.domain.usecase.TourismUseCase

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}