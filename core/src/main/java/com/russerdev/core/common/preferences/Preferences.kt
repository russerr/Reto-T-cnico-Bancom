package com.russerdev.core.common.preferences

interface Preferences {

    suspend fun putSession(key: String, value: String)

    suspend fun getSession(key: String): String?

}