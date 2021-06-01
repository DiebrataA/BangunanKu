package com.anggarad.dev.bangunganku.data.repository

import com.anggarad.dev.bangunganku.data.network.ApiService

class UserRepository(private val api: ApiService) : BaseRepository() {

//    private val _loginResponse = MutableLiveData<String>()
//    val loginResponse : LiveData<String> = _loginResponse

    suspend fun userLogin(email: String, password: String) = safeApiCall {
        api.userLogin(email, password)
    }
}

// val client = RemoteDataSource.getApiService().userLogin(email, password)
//        client.enqueue(object: Callback<ResponseBody> {
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if(response.isSuccessful){
//                    _loginResponse.value = response.body()?.string()
//                } else{
//                    _loginResponse.value = response.errorBody()?.string()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                _loginResponse.value = t.message
//            }
//
//        })