package com.russerdev.retotecnicobancom

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.russerdev.core.common.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: Preferences
): ViewModel() {

    var route by mutableStateOf("/Onboarding_Module")
        private set

    init {
        getStartNavigation()
    }

    private fun getStartNavigation() {
        viewModelScope.launch {
            sharedPreferences.getSession("session_key")?.let { r ->
                if (r.isNotEmpty()) route = "/Home_Module"

            }
        }
    }
}