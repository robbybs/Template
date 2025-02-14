package com.rbs.hilttemplate.core.domain.interactor

import com.rbs.hilttemplate.core.domain.repository.ITourismRepository
import com.rbs.hilttemplate.core.domain.model.Tourism
import com.rbs.hilttemplate.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}