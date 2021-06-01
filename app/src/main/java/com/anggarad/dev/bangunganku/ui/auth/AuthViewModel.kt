package com.anggarad.dev.bangunganku.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anggarad.dev.bangunganku.data.network.Resource
import com.anggarad.dev.bangunganku.data.repository.UserRepository
import com.anggarad.dev.bangunganku.data.source.remote.response.LoginResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AuthViewModel(private val repos: UserRepository) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>> = _loginResponse


    fun login(email: String, password: String): Job {
        return viewModelScope.launch {
            _loginResponse.value = repos.userLogin(email, password)
        }
    }
    //fun onLoginButtonClick(view: View){
//        authListener?.onStarted()
//        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
//            authListener?.onFailure("Invalid email or password!")
//            return
//        }
//
//        val loginResponse = UserRepository().userLogin(email!!, password!!)
//        authListener?.onSuccess()
//    }

}