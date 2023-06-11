package com.guijarro.smalldice.domain

import com.guijarro.smalldice.data.RandomNumberDto

data class NumberModel(
    val number: String
)

fun String?.mapToDomainNumber(): NumberModel {
    return NumberModel(
        number =  this?.replace("\n","")?: "Error"
    )
}


