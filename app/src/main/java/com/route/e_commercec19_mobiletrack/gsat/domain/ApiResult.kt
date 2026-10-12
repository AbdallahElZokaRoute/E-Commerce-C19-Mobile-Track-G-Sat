package com.route.e_commercec19_mobiletrack.gsat.domain

import com.route.e_commercec19_mobiletrack.gsat.data.api.utls.AppExceptions

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error(val message: AppExceptions?) : ApiResult<Nothing>
}
