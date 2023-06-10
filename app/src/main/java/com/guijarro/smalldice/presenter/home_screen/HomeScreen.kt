package com.guijarro.smalldice.presenter.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.guijarro.smalldice.utils.UIState

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column {
        when (val state = viewModel.randomNumber.value) {
            is UIState.LOADING -> {
                CircularProgressIndicator(modifier = Modifier.fillMaxSize())
            }
            is UIState.SUCCESS -> {
                 Text(text = state.data.number)

            }

            is UIState.ERROR -> {
                Text(text = "error")
            }
        }

        Button(
            onClick = { viewModel.getRandomNumber() }
        ) {
            Text("Roll")
        }
    }
}