package com.guijarro.smalldice.data

import com.guijarro.smalldice.domain.Repository
import retrofit2.Response

class RepositoryImpl(
    private val api: RandomNumberApi
): Repository {

    override suspend fun getRandomNumber(): Response<RandomNumberDto> {
        return api.getRandomNumber()
    }
}