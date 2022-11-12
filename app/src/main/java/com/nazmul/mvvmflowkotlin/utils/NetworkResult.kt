package com.nazmul.mvvmflowkotlin.utils

sealed class NetworkResult<out R> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Loading<out T>(val loadingState: Boolean) : NetworkResult<T>()
    data class Error(val message: String,val code:Int) : NetworkResult<Nothing>()
}
