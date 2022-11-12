package com.nazmul.mvvmflowkotlin.network

import com.nazmul.mvvmflowkotlin.model.PopularTvShow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/most-popular")
    suspend fun getPopularTvShow(
        @Query("page") page : Int
    ) : Response<PopularTvShow>
}