package com.github.jesushzc.tvapp.domain.di

import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository
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

}