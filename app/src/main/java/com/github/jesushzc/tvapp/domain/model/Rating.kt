package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Rating (

  @field:Json(name = "average" ) var average : Double? = null

)