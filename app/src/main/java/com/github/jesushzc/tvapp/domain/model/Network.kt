package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Network (

  @field:Json(name = "id"           ) var id           : Int?     = null,
  @field:Json(name = "name"         ) var name         : String?  = null,
  @field:Json(name = "country"      ) var country      : Country? = Country(),
  @field:Json(name = "officialSite" ) var officialSite : String?  = null

)