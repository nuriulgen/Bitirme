package com.nuriulgen.bitirmeodevi.presentation.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuriulgen.bitirmeodevi.domain.model.TopDestinationModel
import com.nuriulgen.bitirmeodevi.domain.usecase.TopDestinationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val topDestinationUseCase: TopDestinationUseCase
): ViewModel() {

    fun fetchDestination(): LiveData<List<TopDestinationModel>> {
        topDestinationUseCase.apply {
            getTopDestination()
            return topDestination
        }
    }
}