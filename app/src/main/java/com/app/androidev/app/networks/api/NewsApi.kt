package com.app.androidev.app.networks.api

import com.app.androidev.app.model.news.ResponseNews
import com.app.androidev.app.model.newsDetails.ResponseNewsDetails
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsApi {

    @GET("/search")
    suspend fun search(
        @Query("q") value: String,
        @Query("from-date") date: String,
        @Query("show-fields") fields: String,
        @Query("api-key") key: String
    ) : ApiResponse<ResponseNews>

    @GET
    suspend fun getApiSection(@Url url : String) : ApiResponse<ResponseNewsDetails>
}