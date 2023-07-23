package com.github.jesushzc.tvapp.domain.use_case

import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository

class TvProgramByNameUseCase(
    private val tvProgramRepository: TvProgramRepository
) {

    suspend operator fun invoke(name: String) = tvProgramRepository.getTvProgramsByName(name)

}