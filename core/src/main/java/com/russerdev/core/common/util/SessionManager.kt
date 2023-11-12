package com.russerdev.core.common.util

class SessionManager {

    private val userSessions: MutableMap<String, Long> = HashMap()

    fun startSession(sessionId: String) {
        userSessions[sessionId] = System.currentTimeMillis()
    }

    fun isSessionExpired(sessionId: String): Boolean {
        val lastLoginTime = userSessions[sessionId] ?: return true
        val currentTime = System.currentTimeMillis()
        val sessionDuration = currentTime - lastLoginTime
        val maxSessionDuration = 15 * 60 * 1000 // 15 minutos en milisegundos

        return sessionDuration > maxSessionDuration
    }
}