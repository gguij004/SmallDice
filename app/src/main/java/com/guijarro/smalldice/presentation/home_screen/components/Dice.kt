package com.guijarro.smalldice.presentation.home_screen.components

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
import com.guijarro.smalldice.utils.Dice

@Composable
fun Dice(
    number: Dice
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
            when (number) {
                Dice.ONE -> FaceOne()
                Dice.TWO -> FaceTwo()
                Dice.THREE -> FaceThree()
                Dice.FOUR -> FaceFour()
                Dice.FIVE -> FaceFive()
                Dice.SIX -> FaceSix()
                Dice.LOADING ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
            }
        }
    }
}