package mehdiparsaei.simonsvoss.assignment.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

private const val PREFERENCES_NAME = "app_preferences"

private val Context.dataStore by preferencesDataStore(PREFERENCES_NAME)

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext appContext: Context) {

    companion object {
        val DATA_LAST_UPDATE = intPreferencesKey("data_last_update")
    }

    private val dataStore = appContext.dataStore

    suspend fun setDataLastUpdate() {
        dataStore.edit { preferences ->
            preferences[DATA_LAST_UPDATE] = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        }
    }

    val dataLastUpdate: Flow<Int> = dataStore.data.map { preferences ->
        preferences[DATA_LAST_UPDATE] ?: 0
    }
}