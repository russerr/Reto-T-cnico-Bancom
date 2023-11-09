package com.russerdev.presentation.login

sealed class LoginEvent {

    data class onInputValueEmail(val value: String): LoginEvent()
    data class onInputValuePassword(val value: String): LoginEvent()
    data class onClickCheckBox(val value: Boolean): LoginEvent()
    object onClickLogin: LoginEvent()
}
