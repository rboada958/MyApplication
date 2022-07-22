package com.app.androidev.ui.views.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.androidev.app.model.news.ResultsItem
import com.app.androidev.app.model.newsDetails.Content
import com.app.androidev.app.usecase.GetNewsDetailsUseCase
import com.app.androidev.app.usecase.GetNewsUseCase
import com.app.androidev.utils.base.DataState
import com.app.androidev.utils.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val getNewsUseCase: GetNewsUseCase,
    val getNewsDetailsUseCase: GetNewsDetailsUseCase
) : ViewModel() {

    val contentLive = MutableLiveData<Event<Content>>()

    private val _newsUiState = MutableLiveData<Event<NewsUiState>>()
    val newsUiState: LiveData<Event<NewsUiState>> get() = _newsUiState

    private val _newsDetailsUiState = MutableLiveData<Event<NewsDetailsUiState>>()
    val newsDetailsUiState: LiveData<Event<NewsDetailsUiState>> get() = _newsDetailsUiState

    fun getNews() =
        viewModelScope.launch {
            getNewsUseCase().collect { data ->
                when (data) {
                    is DataState.Loading -> {
                        _newsUiState.value = Event(NewsUiState.ShowLoading)
                    }
                    is DataState.success -> {
                        _newsUiState.value = Event(
                            NewsUiState.SuccessNews(data.data.response!!.results!!)
                        )
                    }
                    is DataState.Error -> {
                        data.exception.printStackTrace()
                        _newsUiState.value = Event(
                            NewsUiState.Error(data.exception.message.orEmpty())
                        )
                    }
                    is DataState.otherError -> {
                        _newsUiState.value = Event(NewsUiState.Error(data.error))
                    }
                }
            }
        }

    fun getNewsDetails(url: String) =
        viewModelScope.launch {
            getNewsDetailsUseCase(url).collect { data ->
                when (data) {
                    is DataState.Loading -> {
                        _newsDetailsUiState.value = Event(NewsDetailsUiState.ShowLoading)
                    }
                    is DataState.success -> {
                        _newsDetailsUiState.value = Event(
                            NewsDetailsUiState.SuccessNewsDetails(data.data.response!!.content!!)
                        )
                    }
                    is DataState.Error -> {
                        data.exception.printStackTrace()
                        _newsDetailsUiState.value = Event(
                            NewsDetailsUiState.Error(data.exception.message.orEmpty())
                        )
                    }
                    is DataState.otherError -> {
                        _newsDetailsUiState.value = Event(NewsDetailsUiState.Error(data.error))
                    }
                }
            }
        }

    sealed class NewsUiState {
        object ShowLoading : NewsUiState()
        class SuccessNews(val result: List<ResultsItem?>) : NewsUiState()
        class Error(val msg: String) : NewsUiState()
    }

    sealed class NewsDetailsUiState {
        object ShowLoading : NewsDetailsUiState()
        class SuccessNewsDetails(val result: Content) : NewsDetailsUiState()
        class Error(val msg: String) : NewsDetailsUiState()
    }
}