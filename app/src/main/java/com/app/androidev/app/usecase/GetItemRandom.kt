package com.app.androidev.app.usecase

import com.app.androidev.ui.mvvm.RandomRepository
import javax.inject.Inject

class GetItemRandom @Inject constructor(private val repository: RandomRepository) {

    suspend operator fun invoke() =
        repository.random()
}