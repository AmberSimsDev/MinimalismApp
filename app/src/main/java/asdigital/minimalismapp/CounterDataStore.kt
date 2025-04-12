package asdigital.minimalismapp

import android.content.Context

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore(name = "counter_prefs")

class CounterDataStore(private val context: Context) {

    // Returns a Flow<Int> for a given key name
    fun getCounterFlow(keyName: String): Flow<Int> {
        val key = intPreferencesKey(keyName)
        return context.dataStore.data.map { preferences ->
            preferences[key] ?: 0
        }
    }

    // Saves a counter for a given key name
    suspend fun saveCounter(keyName: String, value: Int) {
        val key = intPreferencesKey(keyName)
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }
}