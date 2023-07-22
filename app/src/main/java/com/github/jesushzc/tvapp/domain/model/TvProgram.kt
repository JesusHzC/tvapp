package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class TvProgram (

  @field:Json(name = "id"       ) var id       : Int?    = null,
  @field:Json(name = "url"      ) var url      : String? = null,
  @field:Json(name = "name"     ) var name     : String? = null,
  @field:Json(name = "season"   ) var season   : Int?    = null,
  @field:Json(name = "number"   ) var number   : Int?    = null,
  @field:Json(name = "type"     ) var type     : String? = null,
  @field:Json(name = "airdate"  ) var airdate  : String? = null,
  @field:Json(name = "airtime"  ) var airtime  : String? = null,
  @field:Json(name = "airstamp" ) var airstamp : String? = null,
  @field:Json(name = "runtime"  ) var runtime  : Int?    = null,
  @field:Json(name = "rating"   ) var rating   : Rating? = Rating(),
  @field:Json(name = "image"    ) var image    : Image?  = Image(),
  @field:Json(name = "summary"  ) var summary  : String? = null,
  @field:Json(name = "show"     ) var show     : Show?   = Show()

)