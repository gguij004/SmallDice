package com.guijarro.smalldice.domain

import com.guijarro.smalldice.utils.UIState
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getRandomNumber(): Flow<UIState<NumberModel>>
}