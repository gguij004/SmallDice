package com.guijarro.smalldice.domain

import com.guijarro.smalldice.data.RandomNumberDto
import retrofit2.Response

interface Repository {
    suspend fun getRandomNumber(): Response<RandomNumberDto>
}