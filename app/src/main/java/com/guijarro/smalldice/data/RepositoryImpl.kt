package com.guijarro.smalldice.data

import com.guijarro.smalldice.domain.NumberModel
import com.guijarro.smalldice.domain.Repository
import com.guijarro.smalldice.domain.mapToDomainNumber
import com.guijarro.smalldice.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
    private val api: RandomNumberApi
) : Repository {

    override suspend fun getRandomNumber(): Flow<UIState<NumberModel>> = flow {

        try {
            val data = api.getRandomNumber()
            if (data.isSuccessful) {
                data.body()?.let {
                    emit(UIState.SUCCESS(it.mapToDomainNumber()))
                } ?: throw Exception("No data")
            } else {
                throw Exception("Network Error")
            }

        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }
}
