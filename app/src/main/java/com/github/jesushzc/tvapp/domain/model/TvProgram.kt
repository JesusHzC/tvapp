package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class TvProgram (

  @SerializedName("id"       ) var id       : Int?    = null,
  @SerializedName("url"      ) var url      : String? = null,
  @SerializedName("name"     ) var name     : String? = null,
  @SerializedName("season"   ) var season   : Int?    = null,
  @SerializedName("number"   ) var number   : Int?    = null,
  @SerializedName("type"     ) var type     : String? = null,
  @SerializedName("airdate"  ) var airdate  : String? = null,
  @SerializedName("airtime"  ) var airtime  : String? = null,
  @SerializedName("airstamp" ) var airstamp : String? = null,
  @SerializedName("runtime"  ) var runtime  : Int?    = null,
  @SerializedName("rating"   ) var rating   : Rating? = Rating(),
  @SerializedName("image"    ) var image    : Image?  = Image(),
  @SerializedName("summary"  ) var summary  : String? = null,
  @SerializedName("show"     ) var show     : Show?   = Show()

)