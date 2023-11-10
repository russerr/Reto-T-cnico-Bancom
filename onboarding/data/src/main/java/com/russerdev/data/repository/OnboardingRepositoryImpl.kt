package com.russerdev.data.repository

import com.russerdev.domain.model.LoginUserRequest
import com.russerdev.domain.repository.OnboardingRepository
import kotlinx.coroutines.delay
import java.util.UUID

class OnboardingRepositoryImpl(): OnboardingRepository {

    // Simula un almacenamiento de sesiones usando un HashMap
    private val userSessions: MutableMap<String, Long> = HashMap()

    override suspend fun loginUser(request: LoginUserRequest): Result<Unit> {
        return try {
            // Realiza la autenticación (puede ser una validación simple)
            val isAuthenticated = authenticateUser(request.email, request.password)

            if (isAuthenticated) {
                // Almacena la sesión del usuario
                val sessionId = generateSessionId()
                userSessions[sessionId] = System.currentTimeMillis()

                // Retorna el éxito con el ID de sesión si es necesario
                delay(5000)
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

    // Verifica si la sesión ha expirado
    private fun isSessionExpired(sessionId: String): Boolean {
        val lastLoginTime = userSessions[sessionId] ?: return true
        val currentTime = System.currentTimeMillis()
        val sessionDuration = currentTime - lastLoginTime
        val maxSessionDuration = 15 * 60 * 1000 // 15 minutos en milisegundos

        return sessionDuration > maxSessionDuration
    }

    // Genera un ID de sesión único (puedes ajustar según tus necesidades)
    private fun generateSessionId(): String {
        return UUID.randomUUID().toString()
    }
}