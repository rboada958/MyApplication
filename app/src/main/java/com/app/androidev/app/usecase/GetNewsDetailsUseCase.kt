package com.app.androidev.app.usecase

import com.app.androidev.ui.views.mvvm.NewsRepository
import javax.inject.Inject

class GetNewsDetailsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke(url : String) =
        repository.getApiSection(url)
}