package com.github.jesushzc.tvapp.data.repository

import com.github.jesushzc.tvapp.data.remote.TvMazeApi
import com.github.jesushzc.tvapp.domain.model.Cast
import com.github.jesushzc.tvapp.domain.model.Show
import com.github.jesushzc.tvapp.domain.model.Talent
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

    override suspend fun getTvProgramsByName(name: String): Resource<TvPrograms> {
        return try {
            val response = api.getTvProgramsByName(name)
            Resource.Success(data = TvPrograms(response))
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = "Ocurrió un error.")
        }
    }

    override suspend fun tvProgramDetail(id: Int): Resource<Show> {
        return try {
            val response = api.tvProgramDetail(id)
            Resource.Success(data = response)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = "Ocurrió un error.")
        }
    }

    override suspend fun getCast(id: Int): Resource<Cast> {
        return try {
            val response = api.getCast(id)
            Resource.Success(data = Cast(response))
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = "Ocurrió un error.")
        }
    }

}