package com.github.jesushzc.tvapp.data.remote

import com.github.jesushzc.tvapp.domain.model.Show
import com.github.jesushzc.tvapp.domain.model.Talent
import com.github.jesushzc.tvapp.domain.model.TvProgram
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvMazeApi {

    @GET("schedule?country=US")
    suspend fun getTvPrograms(@Query("date") date: String): List<TvProgram>

    @GET("search/shows")
    suspend fun getTvProgramsByName(@Query("q") name: String): List<TvProgram>

    @GET("shows/{id}")
    suspend fun tvProgramDetail(@Path("id") id: Int): Show

    @GET("shows/{id}/cast")
    suspend fun getCast(@Path("id") id: Int): List<Talent>

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
    }

}