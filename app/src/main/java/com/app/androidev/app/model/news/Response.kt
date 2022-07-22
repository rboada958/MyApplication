package com.app.androidev.app.model.news

import com.squareup.moshi.Json

data class Response(

    @Json(name="userTier")
	val userTier: String? = null,

    @Json(name="total")
	val total: Int? = null,

    @Json(name="startIndex")
	val startIndex: Int? = null,

    @Json(name="pages")
	val pages: Int? = null,

    @Json(name="pageSize")
	val pageSize: Int? = null,

    @Json(name="orderBy")
	val orderBy: String? = null,

    @Json(name="currentPage")
	val currentPage: Int? = null,

    @Json(name="results")
	val results: List<ResultsItem?>? = null,

    @Json(name="status")
	val status: String? = null
)