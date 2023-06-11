package com.guijarro.smalldice.presenter.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Dice(
    number: String
) {
    Box(
        modifier = Modifier
            .border(BorderStroke(4.dp, Color.Black), shape = RoundedCornerShape(10))
            .size(100.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,

        ) {
            if (number == "0") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            if (number == "1") {
                FaceOne()
            }
            if (number == "2") {
                FaceTwo()
            }
            if (number == "3") {
                FaceThree()
            }
            if (number == "4") {
                FaceFour()
            }
            if (number == "5") {
                FaceFive()
            }
            if (number == "6") {
                FaceSix()
            }
        }
    }
}