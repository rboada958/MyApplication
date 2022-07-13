package com.app.androidev.app.di

import com.app.androidev.app.networks.api.RandomApi
import com.app.androidev.ui.mvvm.RandomRepository
import com.app.androidev.ui.mvvm.RandomRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun providesRandomRepository(api: RandomApi) : RandomRepository =
        RandomRepositoryImpl(api)
}