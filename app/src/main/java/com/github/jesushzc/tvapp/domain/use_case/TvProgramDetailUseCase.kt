package com.github.jesushzc.tvapp.domain.use_case

import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository

class TvProgramDetailUseCase(
    private val tvProgramRepository: TvProgramRepository
) {

    suspend operator fun invoke(id: Int) = tvProgramRepository.tvProgramDetail(id)

}