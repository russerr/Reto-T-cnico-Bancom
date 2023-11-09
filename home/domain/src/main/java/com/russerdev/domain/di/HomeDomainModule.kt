package com.russerdev.domain.di

import com.russerdev.domain.repository.HomeRepository
import com.russerdev.domain.uses_cases.GetPostsUseCase
import com.russerdev.domain.uses_cases.HomeUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeDomainModule {

    @ViewModelScoped
    @Provides
    fun provideHomeUsesCases(repository: HomeRepository): HomeUsesCases {
        return HomeUsesCases(
            getPostUseCase = GetPostsUseCase(repository)
        )
    }
}