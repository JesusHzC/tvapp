package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Network (

  @SerializedName("id"           ) var id           : Int?     = null,
  @SerializedName("name"         ) var name         : String?  = null,
  @SerializedName("country"      ) var country      : Country? = Country(),
  @SerializedName("officialSite" ) var officialSite : String?  = null

)