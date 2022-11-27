package com.nazmul.mvvmflowkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nazmul.mvvmflowkotlin.model.PopularTvShow
import com.nazmul.mvvmflowkotlin.model.TvShow
import com.nazmul.mvvmflowkotlin.repository.PopularTvShowRepo
import com.nazmul.mvvmflowkotlin.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularTvShowViewModel @Inject constructor(
    private val tvShowRepo: PopularTvShowRepo

    ) : ViewModel(){

    val errorMessage = MutableLiveData<String>()

//        private var _tvShowResponse = MutableLiveData<NetworkResult<PopularTvShow>>()
//        val tvShowResponse : LiveData<NetworkResult<PopularTvShow>> = _tvShowResponse


//    fun getPopularTvShow(page : Int) {
//
//        viewModelScope.launch {
//            tvShowRepo.getPopularTvShow(page).collect{
//                _tvShowResponse.postValue(it)
//            }
//        }
//    }

    fun getPopularTvShow(): LiveData<PagingData<TvShow>> {
        return tvShowRepo.getPopularTvShow().cachedIn(viewModelScope)
    }



}