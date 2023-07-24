package com.github.jesushzc.tvapp.domain.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self") var self: Self? = Self(),
    @SerializedName("previousepisode") var previousepisode: Previousepisode? = Previousepisode(),
)
