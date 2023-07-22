package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Image (

  @field:Json(name = "medium"   ) var medium   : String? = null,
  @field:Json(name = "original" ) var original : String? = null

)