package com.app.androidev.app.model.newsDetails

import com.squareup.moshi.Json

data class Content(

	@Json(name="sectionName")
	val sectionName: String? = null,

	@Json(name="pillarName")
	val pillarName: String? = null,

	@Json(name="webPublicationDate")
	val webPublicationDate: String? = null,

	@Json(name="apiUrl")
	val apiUrl: String? = null,

	@Json(name="webUrl")
	val webUrl: String? = null,

	@Json(name="isHosted")
	val isHosted: Boolean? = null,

	@Json(name="pillarId")
	val pillarId: String? = null,

	@Json(name="webTitle")
	val webTitle: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="sectionId")
	val sectionId: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="fields")
	val fields: Fields? = null
)