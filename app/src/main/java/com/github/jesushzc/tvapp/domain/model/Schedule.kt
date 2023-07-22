package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Schedule (

  @field:Json(name = "time" ) var time : String?           = null,
  @field:Json(name = "days" ) var days : ArrayList<String> = arrayListOf()

)