package com.github.jesushzc.tvapp.domain.use_case

import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository

class TvProgramUseCase(
    private val tvProgramRepository: TvProgramRepository
) {

    suspend operator fun invoke(date: String) = tvProgramRepository.getTvPrograms(date)

}