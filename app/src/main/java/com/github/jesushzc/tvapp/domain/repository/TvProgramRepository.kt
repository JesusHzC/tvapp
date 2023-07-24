package com.github.jesushzc.tvapp.domain.repository

import com.github.jesushzc.tvapp.domain.model.Cast
import com.github.jesushzc.tvapp.domain.model.Show
import com.github.jesushzc.tvapp.domain.model.TvPrograms
import com.github.jesushzc.tvapp.utils.Resource

interface TvProgramRepository {

    suspend fun getTvPrograms(date: String): Resource<TvPrograms>

    suspend fun getTvProgramsByName(name: String): Resource<TvPrograms>

    suspend fun tvProgramDetail(id: Int): Resource<Show>

    suspend fun getCast(id: Int): Resource<Cast>

}