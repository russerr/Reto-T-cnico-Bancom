package com.russerdev.domain.di

import com.russerdev.domain.repository.OnboardingRepository
import com.russerdev.domain.uses_cases.LoginUserUseCase
import com.russerdev.domain.uses_cases.OnboardingUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OnboardingDomainModule {

    @ViewModelScoped
    @Provides
    fun provideOnboardingUsesCases(repository: OnboardingRepository): OnboardingUsesCases {
        return OnboardingUsesCases(
            loginUserUseCase = LoginUserUseCase(repository)
        )
    }
}