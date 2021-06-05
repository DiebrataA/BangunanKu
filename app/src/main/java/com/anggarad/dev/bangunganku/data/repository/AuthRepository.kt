package com.anggarad.dev.bangunganku.data.repository

import com.anggarad.dev.bangunganku.data.UserPreferences
import com.anggarad.dev.bangunganku.data.network.ApiService

class AuthRepository(
    private val api: ApiService,
    private val preferences: UserPreferences
) : BaseRepository() {


    suspend fun userLogin(email: String, password: String) = safeApiCall {
        api.userLogin(email, password)
    }

    suspend fun saveCredentials(token: String, userName: String) {
        preferences.saveUserCredentials(token, userName)
    }

}
