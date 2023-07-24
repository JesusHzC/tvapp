package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName


data class Rating (

  @SerializedName("average" ) var average : Double? = null

)