package com.app.androidev.ui.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.androidev.app.model.ResponseRandom
import com.app.androidev.app.usecase.GetItemRandom
import com.app.androidev.utils.base.DataState
import com.app.androidev.utils.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    val getItemRandom: GetItemRandom
): ViewModel() {

    private val mutableList : MutableList<ResponseRandom> = mutableListOf()
    val listLive = MutableLiveData<Event<List<ResponseRandom>>>()

    fun itemRandoms() =
        viewModelScope.launch {
            getItemRandom().collect { data ->
                when (data) {
                    is DataState.success -> {
                        mutableList.add(data.data)
                    }
                    else -> {}
                }
            }
            listLive.value = Event(mutableList)
        }
}