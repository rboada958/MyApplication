package com.app.androidev.app.model.newsDetails

import com.squareup.moshi.Json

data class Fields(

    @Json(name = "headline")
    val headline: String? = null,

    @Json(name = "standfirst")
    val standFirst: String? = null,

    @Json(name = "trailText")
    val trailText: String? = null,

    @Json(name = "byline")
    val byline: String? = null,

    @Json(name = "main")
    val main: String? = null,

    @Json(name = "body")
    val body: String? = null,

    @Json(name = "bodyText")
    val bodyText: String? = null,

    @Json(name = "thumbnail")
    val thumbnail: String? = null
)