package com.rbs.kointemplate

import android.app.Application
import com.rbs.kointemplate.core.di.databaseModule
import com.rbs.kointemplate.core.di.networkModule
import com.rbs.kointemplate.core.di.repositoryModule
import com.rbs.kointemplate.di.useCaseModule
import com.rbs.kointemplate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}