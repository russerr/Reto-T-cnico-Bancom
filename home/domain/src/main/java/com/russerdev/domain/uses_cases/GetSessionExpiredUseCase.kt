package com.russerdev.domain.uses_cases

import com.russerdev.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetSessionExpiredUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(): Flow<Result<Boolean>> {
        return repository.isSessionExpired()
    }
}