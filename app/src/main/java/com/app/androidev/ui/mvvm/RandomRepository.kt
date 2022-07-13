package com.app.androidev.ui.mvvm

import com.app.androidev.app.model.ResponseRandom
import com.app.androidev.utils.base.DataState
import kotlinx.coroutines.flow.Flow

interface RandomRepository {

    suspend fun random() : Flow<DataState<ResponseRandom>>
}