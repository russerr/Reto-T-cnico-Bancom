package com.russerdev.core.common.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.russerdev.core.common.di.Contans

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Contans.APP_DATA_STORE_NAME)