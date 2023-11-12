package com.russerdev.core.common.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first


class PreferencesImpl(private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>): Preferences {
    override suspend fun putSession(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        dataStore.edit { p->
            p[preferencesKey] = value
        }
    }

    override suspend fun getSession(key: String): String? {
        return try {
            val preferencesKey = stringPreferencesKey(key)
            val preferences = dataStore.data.first()
            preferences[preferencesKey]
        } catch (e: Exception) {
            null
        }
    }
}