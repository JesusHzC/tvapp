package com.github.jesushzc.tvapp.domain.di

import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository
import com.github.jesushzc.tvapp.domain.use_case.CastUseCase
import com.github.jesushzc.tvapp.domain.use_case.DateFormatterUseCase
import com.github.jesushzc.tvapp.domain.use_case.TvProgramByNameUseCase
import com.github.jesushzc.tvapp.domain.use_case.TvProgramDetailUseCase
import com.github.jesushzc.tvapp.domain.use_case.TvProgramUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TvProgramModule {

    @Provides
    @ViewModelScoped
    fun provideTvProgramUseCase(
        repository: TvProgramRepository
    ): TvProgramUseCase {
        return TvProgramUseCase(
            repository
        )
    }

    @Provides
    @ViewModelScoped
    fun provideTvProgramByNameUseCase(
        repository: TvProgramRepository
    ): TvProgramByNameUseCase {
        return TvProgramByNameUseCase(
            repository
        )
    }

    @Provides
    @ViewModelScoped
    fun provideTvProgramDetailUseCase(
        repository: TvProgramRepository
    ): TvProgramDetailUseCase {
        return TvProgramDetailUseCase(
            repository
        )
    }

    @Provides
    @ViewModelScoped
    fun provideCastUseCase(
        repository: TvProgramRepository
    ): CastUseCase {
        return CastUseCase(
            repository
        )
    }

    @Provides
    @ViewModelScoped
    fun provideDateFormatterUseCase(): DateFormatterUseCase {
        return DateFormatterUseCase()
    }

}