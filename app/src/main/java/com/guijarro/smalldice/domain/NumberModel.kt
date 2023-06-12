package com.guijarro.smalldice.domain

import com.guijarro.smalldice.utils.Dice

data class NumberModel(
    val number: Dice
)

fun String?.mapToDomainNumber(): NumberModel {

    val number = this?.replace("\n", "") ?: "Error"
    var num = Dice.LOADING

    when (number) {
        "1" -> {
            num = Dice.ONE
        }

        "2" -> {
            num = Dice.TWO
        }

        "3" -> {
            num = Dice.THREE
        }

        "4" -> {
            num = Dice.FOUR
        }

        "5" -> {
            num = Dice.FIVE
        }

        "6" -> {
            num = Dice.SIX
        }
    }

    return NumberModel(
        number = num
    )
}


