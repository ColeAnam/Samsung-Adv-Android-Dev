package com.example.assignment1.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map

class StoreStudentInfo(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("StudentInfo")

        val STUDENT_USERNAME_KEY = stringPreferencesKey("student_username")
        val STUDENT_EMAIL_KEY = stringPreferencesKey("student_email")
        val STUDENT_ID_KEY = stringPreferencesKey("student_id")
    }

    val getUsername: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[STUDENT_USERNAME_KEY] ?: ""
        }

    val getEmail: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[STUDENT_EMAIL_KEY] ?: ""
        }

    val getID: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[STUDENT_ID_KEY] ?: ""
        }

    suspend fun saveInfo(username: String, email: String, id: String) {
        context.dataStore.edit { preferences ->
            preferences[STUDENT_USERNAME_KEY] = username
            preferences[STUDENT_EMAIL_KEY] = email
            preferences[STUDENT_ID_KEY] = id
        }
    }

}