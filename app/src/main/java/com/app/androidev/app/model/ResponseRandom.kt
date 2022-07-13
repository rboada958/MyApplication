package com.app.androidev.app.model

import com.squareup.moshi.Json

data class ResponseRandom(

    @Json(name = "icon_url")
    val iconUrl: String? = null,

    @Json(name = "updated_at")
    val updatedAt: String? = null,

    @Json(name = "created_at")
    val createdAt: String? = null,

    @Json(name = "categories")
    val categories: List<Any?>? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "value")
    val value: String? = null,

    @Json(name = "url")
    val url: String? = null
)