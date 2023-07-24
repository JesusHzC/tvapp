package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Person (

  @SerializedName("id"       ) var id       : Int?     = null,
  @SerializedName("url"      ) var url      : String?  = null,
  @SerializedName("name"     ) var name     : String?  = null,
  @SerializedName("country"  ) var country  : Country? = Country(),
  @SerializedName("birthday" ) var birthday : String?  = null,
  @SerializedName("deathday" ) var deathday : String?  = null,
  @SerializedName("gender"   ) var gender   : String?  = null,
  @SerializedName("image"    ) var image    : Image?   = Image(),
  @SerializedName("updated"  ) var updated  : Int?     = null,
  @SerializedName("_links"   ) var Links    : Links?   = Links()

)