package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Character (

  @SerializedName("id"     ) var id    : Int?    = null,
  @SerializedName("url"    ) var url   : String? = null,
  @SerializedName("name"   ) var name  : String? = null,
  @SerializedName("image"  ) var image : Image?  = Image(),
  @SerializedName("_links" ) var Links : Links?  = Links()

)