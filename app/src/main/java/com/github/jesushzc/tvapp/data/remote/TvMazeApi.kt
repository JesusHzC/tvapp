package com.github.jesushzc.tvapp.data.remote

import com.github.jesushzc.tvapp.domain.model.TvPrograms
import retrofit2.http.GET

interface TvMazeApi {

    @GET("schedule?country=US&date={date}")
    suspend fun getTvPrograms(date: String): TvPrograms

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
    }

}