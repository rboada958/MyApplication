package com.app.androidev.app.model.newsDetails

import com.squareup.moshi.Json

data class Response(

	@Json(name="userTier")
	val userTier: String? = null,

	@Json(name="total")
	val total: Int? = null,

	@Json(name="content")
	val content: Content? = null,

	@Json(name="status")
	val status: String? = null
)