package com.androplate.auth.login.contract

import com.androplate.core.base.UiEffect
import com.androplate.core.base.UiEvent
import com.androplate.core.base.UiState

class LoginContract  {
    sealed class Event : UiEvent {
        data class UpdateGoalData(val currentGoalId: String?) : Event()

    }

    data class State(
        val isLoading: Boolean = false,
    ) : UiState


    sealed class Effect : UiEffect {

        data class ShowError(val generaUIModel: String) : Effect()

    }
}