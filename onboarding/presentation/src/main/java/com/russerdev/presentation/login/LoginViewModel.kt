package com.russerdev.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.russerdev.domain.model.LoginUserRequest
import com.russerdev.domain.uses_cases.OnboardingUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val onboardingUsesCases: OnboardingUsesCases
): ViewModel() {

    private val _screenState: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState())
    val screenState get() = _screenState

    private val _uiEvent = Channel<UiEventLogin>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.onClickCheckBox -> onClickCheckBox(event.value)
            LoginEvent.onClickLogin -> loginUser()
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

    private fun loginUser() {

        _screenState.update { it.copy(isLoading = true) }
        val request = LoginUserRequest(
            email = screenState.value.inputEmail,
            password = screenState.value.inputPassword
        )

        viewModelScope.launch {

            onboardingUsesCases
                .loginUserUseCase(request)
                .onSuccess {
                    _screenState.update { it.copy(isLoading = false) }
                    _uiEvent.send(UiEventLogin.Success)
                }
                .onFailure {
                    _screenState.update { it.copy(isLoading = false) }
                }
        }
    }
}