package com.anggarad.dev.bangunganku.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences(context: Context) {
    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences> = applicationContext.createDataStore(
        name = "user data store"
    )

    companion object {
        private val KEY_AUTH = preferencesKey<String>("key_auth")
    }

    val accessToken: Flow<String?>
        get() {
            return dataStore.data.map { preferences ->
                preferences[KEY_AUTH]
            }
        }

    suspend fun saveAccessToken(accessToken: String) {
        dataStore.edit { preferences ->
            preferences[KEY_AUTH] = accessToken
        }
    }


}