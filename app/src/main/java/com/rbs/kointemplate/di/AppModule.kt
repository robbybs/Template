package com.rbs.kointemplate.di

import com.rbs.kointemplate.core.domain.interactor.TourismInteractor
import com.rbs.kointemplate.core.domain.usecase.TourismUseCase
import com.rbs.kointemplate.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}