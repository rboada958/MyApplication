package com.app.androidev.app.di

import com.app.androidev.app.networks.api.NewsApi
import com.app.androidev.ui.views.mvvm.NewsRepository
import com.app.androidev.ui.views.mvvm.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun providesNewsRepository(api: NewsApi) : NewsRepository =
        NewsRepositoryImpl(api)
}