package com.nazmul.mvvmflowkotlin.pagin

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nazmul.mvvmflowkotlin.model.TvShow
import com.nazmul.mvvmflowkotlin.network.ApiService

class TvShowPaginSource(private val apiService: ApiService) : PagingSource<Int,TvShow>() {
    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        return try {
            val position = params.key ?: 1
            val response = apiService.getPopularTvShow(position)
            LoadResult.Page(
                data = response.body()!!.tv_shows,
                prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1
            )
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}