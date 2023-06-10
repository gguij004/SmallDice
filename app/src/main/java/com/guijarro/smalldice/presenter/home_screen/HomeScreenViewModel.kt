package com.guijarro.smalldice.presenter.home_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guijarro.smalldice.domain.GetNumberUseCase
import com.guijarro.smalldice.domain.NumberModel
import com.guijarro.smalldice.utils.UIState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class HomeScreenViewModel(

    private val getNumberUseCase: GetNumberUseCase

) : ViewModel() {

    private val _randomNumber: MutableState<UIState<NumberModel>> = mutableStateOf(UIState.LOADING)
    val randomNumber: State<UIState<NumberModel>> = _randomNumber

    init {

    }

    fun getRandomNumber() {
        getNumberUseCase().onEach { state ->
            if (state is UIState.SUCCESS) {
                _randomNumber.value = state
            }

        }.launchIn(viewModelScope)
    }

}