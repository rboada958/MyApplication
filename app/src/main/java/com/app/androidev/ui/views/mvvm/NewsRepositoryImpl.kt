package com.app.androidev.ui.views.mvvm

import com.app.androidev.app.model.news.ResponseNews
import com.app.androidev.app.model.newsDetails.ResponseNewsDetails
import com.app.androidev.app.networks.api.NewsApi
import com.app.androidev.utils.base.DataState
import com.app.androidev.utils.runRemoteApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi) : NewsRepository {

    override suspend fun search(): Flow<DataState<ResponseNews>> =
        flow {
            emit(DataState.Loading)
            runRemoteApiCall(
                success = {
                    emit(DataState.success(data = data))
                }
            ) {
                api.search(
                    value = "space",
                    date = "2022-01-01",
                    fields = "thumbnail",
                    key = "4ecd1b97-6da0-4121-9457-c31a42b3fe6a"
                )
            }
        }

    override suspend fun getApiSection(url: String): Flow<DataState<ResponseNewsDetails>> =
        flow {
            emit(DataState.Loading)
            runRemoteApiCall(
                success = {
                    emit(DataState.success(data = data))
                }
            ) {
                val value = "$url?api-key=4ecd1b97-6da0-4121-9457-c31a42b3fe6a&show-fields=all"
                api.getApiSection(url = value)
            }
        }
}