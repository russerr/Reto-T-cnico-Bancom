package com.russerdev.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

@Composable
fun LoginScreen(
    state: LoginState,
    uiEvent: Flow<UiEventLogin>,
    onEvent: (LoginEvent) -> Unit,
    onNextScreen: () -> Unit
) {

    LaunchedEffect(key1 = true) {
        uiEvent.collect { event ->
            when (event) {
                UiEventLogin.Success -> onNextScreen()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Text(text = "Bienvenido")
            Text(text = "Inicia sesión")

            OutlinedTextField(
                value = state.inputEmail,
                onValueChange = { onEvent(LoginEvent.onInputValueEmail(it)) },
                label = { Text("Correo electrónico") }
            )

            OutlinedTextField(
                value = state.inputPassword,
                onValueChange = { onEvent(LoginEvent.onInputValuePassword(it)) },
                label = { Text("Contraseña") }
            )

            Box(Modifier.fillMaxWidth()) {
                TextButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterEnd)) {
                    Text(text = "¿Olvidaste tu contraseña?")
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.checkBoxEmail,
                    onCheckedChange = { onEvent(LoginEvent.onClickCheckBox(it)) }
                )
                Text("Recordar correo")
            }


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Button(onClick = { onEvent(LoginEvent.onClickLogin) }) {
                Text(text = "Ingresar")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Ingresar con google")
            }
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    //LoginScreen()
}
