package com.route.e_commercec19_mobiletrack.gsat.data.api.utls

import android.util.Log
import com.route.e_commercec19_mobiletrack.gsat.data.api.models.ErrorModel
import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import retrofit2.Response


fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Flow<ApiResult<T>> =
    flow {
        val response = apiCall()
        if (response.isSuccessful) {
            if (response.body() != null)
                emit(ApiResult.Success(response.body()!!))
            else
                emit(ApiResult.Error(AppExceptions.NoDataException))
        } else if (response.code() in 500..599) {
            emit(ApiResult.Error(AppExceptions.ServerException("Server is Down")))
        } else {
//            Log.e("API Test0", "safeApiCall: ${response.errorBody()?.string()}")
            val errorModel =
                parseErrorSafely(response.errorBody()?.string())
            emit(ApiResult.Error(AppExceptions.ClientError(errorModel?.message)))
        }
    }.catch {
        emit(ApiResult.Error(AppExceptions.UnknownError(it.message)))
    }

fun parseErrorSafely(jsonString: String?): ErrorModel? {
    Log.e("API Test7", "safeApiCall: $jsonString ")
    if (jsonString == null || jsonString.isEmpty() || jsonString.isBlank()) return null
    return runCatching {
        Json { ignoreUnknownKeys = true }.decodeFromString<ErrorModel>(jsonString)
    }.getOrNull()
}


sealed class AppExceptions(val errorMessage: String?) {
    data object NoDataException : AppExceptions(errorMessage = "No Data Found !")
    data class ServerException(val serverMessage: String?) :
        AppExceptions(errorMessage = serverMessage)

    data class ClientError(val message: String?) : AppExceptions(errorMessage = message)
    data class UnknownError(val message: String?) : AppExceptions(errorMessage = message)
}
