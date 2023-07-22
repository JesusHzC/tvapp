package com.github.jesushzc.tvapp.domain.repository

import com.github.jesushzc.tvapp.domain.model.TvPrograms
import com.github.jesushzc.tvapp.utils.Resource

interface TvProgramRepository {

    suspend fun getTvPrograms(date: String): Resource<TvPrograms>

}