package com.anggarad.dev.bangunganku.ui.home

import androidx.lifecycle.ViewModel
import com.anggarad.dev.bangunganku.data.repository.UserRepository

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

//    private val _user: MutableLiveData<Resource<UserResponse>> = MutableLiveData()
//    val user: LiveData<Resource<UserResponse>>
//    get() = _user
//
//    fun getUser() = viewModelScope.launch {
//        _user.value = Resource.Loading
//        _user.value = repository.getUser()
//    }

}