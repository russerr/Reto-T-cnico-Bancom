package com.russerdev.presentation.login

data class LoginState(
    val inputEmail: String = "",
    val inputPassword: String = "",
    val checkBoxEmail: Boolean = false,
)
