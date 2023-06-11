package com.guijarro.smalldice.presenter.home_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guijarro.smalldice.domain.GetNumberUseCase
import com.guijarro.smalldice.domain.NumberModel
import com.guijarro.smalldice.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(

    private val getNumberUseCase: GetNumberUseCase

) : ViewModel() {

    private val _randomNumber: MutableState<UIState<NumberModel>> = mutableStateOf(
        UIState.SUCCESS(
            NumberModel(number = "1")
        )
    )
    val randomNumber: State<UIState<NumberModel>> = _randomNumber

    fun getRandomNumber() {
        getNumberUseCase().onEach { state ->
            if (state is UIState.SUCCESS) {
                _randomNumber.value = state
            }else if (state is UIState.LOADING){
                _randomNumber.value = state
            }

        }.launchIn(viewModelScope)
    }

}