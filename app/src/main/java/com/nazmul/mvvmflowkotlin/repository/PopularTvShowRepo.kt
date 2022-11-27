package com.nazmul.mvvmflowkotlin.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.nazmul.mvvmflowkotlin.model.TvShow
import com.nazmul.mvvmflowkotlin.network.ApiService
import com.nazmul.mvvmflowkotlin.pagin.TvShowPaginSource
import com.nazmul.mvvmflowkotlin.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularTvShowRepo @Inject constructor(private val apiService: ApiService) {


    private val NETWORK_PAGE_SIZE = 20
//    suspend fun getPopularTvShow(page :Int) = flow {
//
//        emit(NetworkResult.Loading(true))
//        val response = apiService.getPopularTvShow(page)
//        if(response.body() != null) {
//            emit(NetworkResult.Success(response.body()!!))
//        }
//
//    }.catch { e ->
//        emit(NetworkResult.Error(e.message ?: "Unkonown Error",-1))
//    }

    fun getPopularTvShow(): LiveData<PagingData<TvShow>> {

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = 2),
            pagingSourceFactory = { TvShowPaginSource(apiService) },
            initialKey = 1
        ).liveData
    }
}