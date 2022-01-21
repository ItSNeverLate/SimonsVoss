package mehdiparsaei.simonsvoss.assignment.data.remote

import mehdiparsaei.simonsvoss.assignment.data.remote.response.ApiResponse
import retrofit2.http.GET

interface AppApi {

    companion object {
        const val BASE_URL = "https://simonsvoss-homework.herokuapp.com/"
    }

    @GET("sv_lsm_data.json")
    suspend fun getData(): ApiResponse
}