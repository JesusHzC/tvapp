package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Schedule (

  @SerializedName("time" ) var time : String?           = null,
  @SerializedName("days" ) var days : ArrayList<String> = arrayListOf()

)