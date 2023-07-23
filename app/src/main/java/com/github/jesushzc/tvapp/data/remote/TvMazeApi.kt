package com.github.jesushzc.tvapp.data.remote

import com.github.jesushzc.tvapp.domain.model.TvProgram
import retrofit2.http.GET
import retrofit2.http.Query

interface TvMazeApi {

    @GET("schedule?country=US")
    suspend fun getTvPrograms(@Query("date") date: String): List<TvProgram>

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
    }

}