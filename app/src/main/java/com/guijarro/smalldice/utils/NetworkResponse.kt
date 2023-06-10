package com.guijarro.smalldice.utils

sealed class NetworkResponse<out T> {
    data class SUCCESS<T>(val data: T) : NetworkResponse<T>()
    data class ERROR(val error: Exception) : NetworkResponse<Nothing>()
}
