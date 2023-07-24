package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Externals (

  @SerializedName("tvrage"  ) var tvrage  : String? = null,
  @SerializedName("thetvdb" ) var thetvdb : Int?    = null,
  @SerializedName("imdb"    ) var imdb    : String? = null

)