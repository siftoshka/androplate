package com.androplate.auth.login

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androplate.auth.login.contract.LoginContract
import com.androplate.uitoolkit.theme.palette
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun LoginScreen(
    onBack: () -> Unit,
    onNavHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel :LoginViewModel = hiltViewModel()

    BackHandler { onBack() }

    Surface(modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                modifier.clickable(onClick = {
                    viewModel.setEvent(
                        LoginContract.Event.UpdateGoalData(
                            currentGoalId = "username"
                        )
                    )
                    onNavHome()
                }),
                color = MaterialTheme.palette.background,
            )
        }
    }
}