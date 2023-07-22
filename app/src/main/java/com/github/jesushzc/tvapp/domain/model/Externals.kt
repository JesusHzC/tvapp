package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Externals (

  @field:Json(name = "tvrage"  ) var tvrage  : String? = null,
  @field:Json(name = "thetvdb" ) var thetvdb : Int?    = null,
  @field:Json(name = "imdb"    ) var imdb    : String? = null

)