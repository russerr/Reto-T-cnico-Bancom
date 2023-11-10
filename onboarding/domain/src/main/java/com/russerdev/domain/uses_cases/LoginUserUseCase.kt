package com.russerdev.domain.uses_cases

import com.russerdev.domain.model.LoginUserRequest
import com.russerdev.domain.repository.OnboardingRepository

class LoginUserUseCase(private val repository: OnboardingRepository) {
    suspend operator fun invoke(request: LoginUserRequest): Result<Unit> {
        return repository.loginUser(request)
    }
}