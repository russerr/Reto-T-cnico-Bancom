package com.russerdev.data.di

import com.russerdev.data.remote.HomeApi
import com.russerdev.data.repository.HomeRepositoryImpl
import com.russerdev.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun providerHomeApi(retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }

    @Provides
    @Singleton
    fun providerHomeRepository(apiService: HomeApi): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }
}