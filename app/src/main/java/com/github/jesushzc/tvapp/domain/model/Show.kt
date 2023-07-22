package com.github.jesushzc.tvapp.domain.model

import com.squareup.moshi.Json


data class Show (

  @field:Json(name = "id"             ) var id             : Int?              = null,
  @field:Json(name = "url"            ) var url            : String?           = null,
  @field:Json(name = "name"           ) var name           : String?           = null,
  @field:Json(name = "type"           ) var type           : String?           = null,
  @field:Json(name = "language"       ) var language       : String?           = null,
  @field:Json(name = "genres"         ) var genres         : ArrayList<String> = arrayListOf(),
  @field:Json(name = "status"         ) var status         : String?           = null,
  @field:Json(name = "runtime"        ) var runtime        : Int?              = null,
  @field:Json(name = "averageRuntime" ) var averageRuntime : Int?              = null,
  @field:Json(name = "premiered"      ) var premiered      : String?           = null,
  @field:Json(name = "ended"          ) var ended          : String?           = null,
  @field:Json(name = "officialSite"   ) var officialSite   : String?           = null,
  @field:Json(name = "schedule"       ) var schedule       : Schedule?         = Schedule(),
  @field:Json(name = "rating"         ) var rating         : Rating?           = Rating(),
  @field:Json(name = "weight"         ) var weight         : Int?              = null,
  @field:Json(name = "network"        ) var network        : Network?          = Network(),
  @field:Json(name = "webChannel"     ) var webChannel     : String?           = null,
  @field:Json(name = "dvdCountry"     ) var dvdCountry     : String?           = null,
  @field:Json(name = "externals"      ) var externals      : Externals?        = Externals(),
  @field:Json(name = "image"          ) var image          : Image?            = Image(),
  @field:Json(name = "summary"        ) var summary        : String?           = null,
  @field:Json(name = "updated"        ) var updated        : Int?              = null

)