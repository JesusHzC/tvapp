package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Country (

  @field:Json(name = "name"     ) var name     : String? = null,
  @field:Json(name = "code"     ) var code     : String? = null,
  @field:Json(name = "timezone" ) var timezone : String? = null

)