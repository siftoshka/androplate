package com.androplate.auth.login

import com.androplate.auth.login.contract.LoginContract
import com.androplate.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : BaseViewModel<LoginContract.Event,LoginContract.State, LoginContract.Effect>() {
    override fun createInitialState() = LoginContract.State()

    override fun handleEvent(event: LoginContract.Event) {
        when(event){
            is LoginContract.Event.UpdateGoalData -> println("12344323413425")
            else ->{}
        }
    }


}