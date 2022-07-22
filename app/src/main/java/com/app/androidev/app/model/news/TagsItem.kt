package com.app.androidev.app.model.news

import com.squareup.moshi.Json

data class TagsItem(

	@Json(name="lastName")
	val lastName: String? = null,

	@Json(name="references")
	val references: List<Any?>? = null,

	@Json(name="webTitle")
	val webTitle: String? = null,

	@Json(name="bio")
	val bio: String? = null,

	@Json(name="sectionId")
	val sectionId: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="bylineLargeImageUrl")
	val bylineLargeImageUrl: String? = null,

	@Json(name="sectionName")
	val sectionName: String? = null,

	@Json(name="firstName")
	val firstName: String? = null,

	@Json(name="apiUrl")
	val apiUrl: String? = null,

	@Json(name="webUrl")
	val webUrl: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="bylineImageUrl")
	val bylineImageUrl: String? = null,

	@Json(name="twitterHandle")
	val twitterHandle: String? = null
)