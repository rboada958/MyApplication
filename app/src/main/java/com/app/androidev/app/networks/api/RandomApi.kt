package com.app.androidev.app.networks.api

import com.app.androidev.app.model.ResponseRandom
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface RandomApi {

    @GET("/jokes/random")
    suspend fun random() : ApiResponse<ResponseRandom>
}