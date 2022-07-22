package com.app.androidev.app.usecase

import com.app.androidev.ui.views.mvvm.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke() =
        repository.search()
}