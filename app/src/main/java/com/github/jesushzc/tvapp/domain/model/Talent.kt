package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Talent (

  @SerializedName("person"    ) var person    : Person?    = Person(),
  @SerializedName("character" ) var character : Character? = Character(),
  @SerializedName("self"      ) var self      : Boolean?   = null,
  @SerializedName("voice"     ) var voice     : Boolean?   = null

)