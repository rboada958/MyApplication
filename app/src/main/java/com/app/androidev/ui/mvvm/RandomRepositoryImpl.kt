package com.app.androidev.ui.mvvm

import com.app.androidev.app.model.ResponseRandom
import com.app.androidev.app.networks.api.RandomApi
import com.app.androidev.utils.base.DataState
import com.app.androidev.utils.runRemoteApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomRepositoryImpl @Inject constructor(private val api: RandomApi) : RandomRepository {

    override suspend fun random(): Flow<DataState<ResponseRandom>> =
        flow {
            emit(DataState.Loading)
            runRemoteApiCall(
                success = {
                    emit(DataState.success(data = data))
                }
            ) {
                api.random()
            }
        }
}