package com.route.e_commercec19_mobiletrack.gsat.data.mapperUtil

import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <T, K> Flow<ApiResult<T>>.mapResource(mapper: (T) -> K): Flow<ApiResult<K>> =
    map {
        when (it) {
            is ApiResult.Error -> ApiResult.Error(it.message)
            is ApiResult.Success -> ApiResult.Success(mapper(it.data))
        }
    }

