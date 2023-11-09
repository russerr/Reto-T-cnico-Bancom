package com.russerdev.presentation.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {

    private val _screenState: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState())
    val screenState get() = _screenState

    private val _uiEvent = Channel<UiEventLogin>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.onClickCheckBox -> onClickCheckBox(event.value)
            LoginEvent.onClickLogin -> TODO()
            is LoginEvent.onInputValueEmail -> onInputValueEmail(event.value)
            is LoginEvent.onInputValuePassword -> onInputValuePassword(event.value)
        }
    }

    private fun onInputValueEmail(text: String) {
        _screenState.update { it.copy(inputEmail = text) }
    }

    private fun onInputValuePassword(text: String) {
        _screenState.update { it.copy(inputPassword = text) }
    }

    private fun onClickCheckBox(check: Boolean) {
        _screenState.update { it.copy(checkBoxEmail = check) }
    }
}