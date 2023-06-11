package com.guijarro.smalldice.presenter.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.guijarro.smalldice.presenter.home_screen.components.Dice
import com.guijarro.smalldice.utils.UIState

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (val state = viewModel.randomNumber.value) {
            is UIState.LOADING -> {
                  Dice( "0")
            }

            is UIState.SUCCESS -> {
                Dice(state.data.number)
            }

            is UIState.ERROR -> {
                Text(text = "error")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { viewModel.getRandomNumber() }
        ) {
            Text("Roll")
        }
    }
}