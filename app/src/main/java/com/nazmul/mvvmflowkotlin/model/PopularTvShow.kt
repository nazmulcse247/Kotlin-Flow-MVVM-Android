package com.nazmul.mvvmflowkotlin.model

data class PopularTvShow(
    val page: Int,
    val pages: Int,
    val total: String,
    val tv_shows: List<TvShow>
)