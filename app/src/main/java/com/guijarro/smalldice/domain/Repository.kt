package com.guijarro.smalldice.domain

import retrofit2.Response

interface Repository {
    suspend fun getRandomNumber(): Response<String>
}