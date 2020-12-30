package com.example.letsdrink.utils

import com.example.letsdrink.utils.Resource.Status.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.Dispatchers

fun <T, A> performGetOperation(
    databaseQuery: () -> Flow<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit
): Flow<Resource<T>> =
    flow {
        emit(Resource.loading())
        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitAll(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == SUCCESS) {
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
            emitAll(source)
        }
    }.flowOn(Dispatchers.IO)