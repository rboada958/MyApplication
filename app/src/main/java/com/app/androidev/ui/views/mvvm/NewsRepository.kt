package com.app.androidev.ui.views.mvvm

import com.app.androidev.app.model.news.ResponseNews
import com.app.androidev.app.model.newsDetails.ResponseNewsDetails
import com.app.androidev.utils.base.DataState
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun search() : Flow<DataState<ResponseNews>>
    suspend fun getApiSection(url: String): Flow<DataState<ResponseNewsDetails>>
}