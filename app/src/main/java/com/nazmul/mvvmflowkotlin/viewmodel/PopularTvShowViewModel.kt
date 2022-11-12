package com.nazmul.mvvmflowkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazmul.mvvmflowkotlin.model.PopularTvShow
import com.nazmul.mvvmflowkotlin.model.TvShow
import com.nazmul.mvvmflowkotlin.repository.PopularTvShowRepo
import com.nazmul.mvvmflowkotlin.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularTvShowViewModel @Inject constructor(
    private val tvShowRepo: PopularTvShowRepo

    ) : ViewModel(){

        private var _tvShowResponse = MutableLiveData<NetworkResult<PopularTvShow>>()
        val tvShowResponse : LiveData<NetworkResult<PopularTvShow>> = _tvShowResponse

    fun getPopularTvShow(page : Int) {

        viewModelScope.launch {
            tvShowRepo.getPopularTvShow(page).collect{
                _tvShowResponse.postValue(it)
            }
        }
    }


}