package com.guijarro.smalldice.utils

sealed class UIState<out T> {
    object LOADING : UIState<Nothing>()
    data class SUCCESS<T>(val data: T) : UIState<T>()
    data class ERROR(val data: Exception) : UIState<Nothing>()
}