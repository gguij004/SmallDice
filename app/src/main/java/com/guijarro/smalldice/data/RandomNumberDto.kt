package com.guijarro.smalldice.data

import com.google.gson.Gson

data class RandomNumberDto(
    val num: String? = null
)

fun RandomNumberDto?.mapToString(): RandomNumberDto =
    RandomNumberDto(
        num = Gson().toJson(this?.num)
    )

