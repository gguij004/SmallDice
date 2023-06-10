package com.guijarro.smalldice.domain

import com.guijarro.smalldice.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNumberUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<UIState<NumberModel>> =
        flow {
            emit(UIState.LOADING)
            repository.getRandomNumber().collect() {
                emit(it)
            }
        }
}





