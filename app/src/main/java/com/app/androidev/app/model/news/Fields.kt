package com.app.androidev.app.model.news

import com.squareup.moshi.Json

data class Fields(

	@Json(name="shortUrl")
	val shortUrl: String? = null,

	@Json(name="headline")
	val headline: String? = null,

	@Json(name="starRating")
	val starRating: String? = null,

	@Json(name="thumbnail")
	val thumbnail: String? = null
)