package com.guijarro.smalldice.domain

import com.guijarro.smalldice.data.RandomNumberDto

data class NumberModel(
    val number: String
)

fun RandomNumberDto?.mapToDomainNumber(): NumberModel =
    NumberModel(
        number = this?.num ?: "Number not available"
    )

