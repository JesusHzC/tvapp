package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Image (

  @SerializedName("medium"   ) var medium   : String? = null,
  @SerializedName("original" ) var original : String? = null

)