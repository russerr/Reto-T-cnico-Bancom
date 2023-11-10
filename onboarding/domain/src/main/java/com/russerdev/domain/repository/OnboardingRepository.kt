package com.russerdev.domain.repository

import com.russerdev.domain.model.LoginUserRequest

interface OnboardingRepository {

    suspend fun loginUser(request: LoginUserRequest): Result<Unit>
}