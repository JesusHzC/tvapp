package com.github.jesushzc.tvapp.domain.use_case

import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository

class CastUseCase(
    private val tvProgramRepository: TvProgramRepository
) {

    suspend operator fun invoke(id: Int) = tvProgramRepository.getCast(id)

}