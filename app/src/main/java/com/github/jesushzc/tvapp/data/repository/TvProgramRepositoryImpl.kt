package com.github.jesushzc.tvapp.data.repository

import com.github.jesushzc.tvapp.data.remote.TvMazeApi
import com.github.jesushzc.tvapp.domain.model.TvPrograms
import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository
import com.github.jesushzc.tvapp.utils.Resource

class TvProgramRepositoryImpl (
    private val api: TvMazeApi
): TvProgramRepository {

    override suspend fun getTvPrograms(date: String): Resource<TvPrograms> {
        return try {
            val response = api.getTvPrograms(date)
            Resource.Success(data = TvPrograms(response))
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = "Ocurrió un error.")
        }
    }

}