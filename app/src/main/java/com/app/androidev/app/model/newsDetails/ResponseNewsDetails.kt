package com.app.androidev.app.model.newsDetails

import com.squareup.moshi.Json

data class ResponseNewsDetails(

	@Json(name="response")
	val response: Response? = null
)