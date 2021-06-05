package com.anggarad.dev.bangunganku.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences(context: Context) {
    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences> = applicationContext.createDataStore(
        name = "user data store"
    )

    companion object {
        private val KEY_AUTH = preferencesKey<String>("key_auth")
        private val USER_NAME = preferencesKey<String>("user_name")
    }

    val accessToken: Flow<String?>
        get() {
            return dataStore.data.map { preferences ->
                preferences[KEY_AUTH]
            }
        }

    val getUserName: Flow<String?>
        get() {
            return dataStore.data.map { preferences ->
                preferences[USER_NAME]
            }
        }

    suspend fun saveUserCredentials(accessToken: String, userName: String) {
        dataStore.edit { preferences ->
            preferences[KEY_AUTH] = accessToken
            preferences[USER_NAME] = userName
        }
    }

    suspend fun logout() {
        dataStore.edit { it.clear() }
    }

}