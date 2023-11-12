package com.russerdev.data.repository

import com.russerdev.core.common.preferences.Preferences
import com.russerdev.core.common.util.SessionManager
import com.russerdev.domain.model.LoginUserRequest
import com.russerdev.domain.repository.OnboardingRepository
import kotlinx.coroutines.delay
import java.util.UUID

class OnboardingRepositoryImpl(
    private val dataStorePreferences: Preferences,
    private val sessionManager: SessionManager
): OnboardingRepository {
    override suspend fun loginUser(request: LoginUserRequest): Result<Unit> {
        return try {
            // Realiza la autenticación (puede ser una validación simple)
            val isAuthenticated = authenticateUser(request.email, request.password)

            if (isAuthenticated) {
                // Almacena la sesión del usuario
                val sessionId = generateSessionId()
                dataStorePreferences.putSession("session_key", sessionId)
                sessionManager.startSession(sessionId)

                delay(3000)
                Result.success(Unit)
            } else {
                // Retorna un error si la autenticación falla
                Result.failure(Exception("Autenticación fallida"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Verifica si el usuario está autenticado
    private fun authenticateUser(username: String, password: String): Boolean {
        // Lógica de autenticación (puede ser una validación simple)
        return username == "usuario" && password == "123456789"
    }

    // Genera un ID de sesión único (puedes ajustar según tus necesidades)
    private fun generateSessionId(): String {
        return UUID.randomUUID().toString()
    }
}