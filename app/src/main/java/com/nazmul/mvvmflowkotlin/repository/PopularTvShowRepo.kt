package com.nazmul.mvvmflowkotlin.repository

import com.nazmul.mvvmflowkotlin.network.ApiService
import com.nazmul.mvvmflowkotlin.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularTvShowRepo @Inject constructor(private val apiService: ApiService) {


    suspend fun getPopularTvShow(page :Int) = flow {

        emit(NetworkResult.Loading(true))
        val response = apiService.getPopularTvShow(page)
        if(response.body() != null) {
            emit(NetworkResult.Success(response.body()!!))
        }

    }.catch { e ->
        emit(NetworkResult.Error(e.message ?: "Unkonown Error",-1))
    }
}