package com.russerdev.data.di

import com.russerdev.data.repository.OnboardingRepositoryImpl
import com.russerdev.domain.repository.OnboardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingDataModule {

    @Provides
    @Singleton
    fun providerOnboardingRepository(): OnboardingRepository {
        return OnboardingRepositoryImpl()
    }
}