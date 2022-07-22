package com.app.androidev.app.model.news

import com.squareup.moshi.Json

data class ResponseNews(

	@Json(name="response")
	val response: Response? = null
)