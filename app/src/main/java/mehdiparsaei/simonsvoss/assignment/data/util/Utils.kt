package mehdiparsaei.simonsvoss.assignment.data.util

import kotlinx.coroutines.flow.*
import mehdiparsaei.simonsvoss.assignment.data.local.preferences.PreferencesManager
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: suspend (ResultType) -> Boolean = {
        true
    },
) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            // Fresh data from DB
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        // Old data from DB
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}