package com.app.androidev.app.di

import com.app.androidev.app.networks.api.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
class AppApiModule {

    @Provides
    fun provideNewsApi(retrofit: Retrofit) : NewsApi = retrofit.create(NewsApi::class.java)
}