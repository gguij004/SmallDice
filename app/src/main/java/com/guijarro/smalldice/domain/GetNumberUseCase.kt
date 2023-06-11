package com.guijarro.smalldice.domain

import com.guijarro.smalldice.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNumberUseCase @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke(): Flow<UIState<NumberModel>> = flow {
        emit(UIState.LOADING)

        try {
            val data = repository.getRandomNumber()
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


    }.flowOn(dispatcher)
}





