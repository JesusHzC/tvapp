package com.github.jesushzc.tvapp.data.di

import com.github.jesushzc.tvapp.data.remote.TvMazeApi
import com.github.jesushzc.tvapp.data.repository.TvProgramRepositoryImpl
import com.github.jesushzc.tvapp.domain.repository.TvProgramRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideTvMazeApi(client: OkHttpClient): TvMazeApi {
        return Retrofit.Builder()
            .baseUrl(TvMazeApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(TvMazeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTvProgramRepository(
        api: TvMazeApi
    ): TvProgramRepository {
        return TvProgramRepositoryImpl(
            api
        )
    }

}