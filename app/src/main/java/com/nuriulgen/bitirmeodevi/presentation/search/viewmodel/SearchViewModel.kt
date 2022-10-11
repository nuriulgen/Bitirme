package com.nuriulgen.bitirmeodevi.presentation.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.usecase.AllUseCase
import com.nuriulgen.bitirmeodevi.domain.usecase.NearbyAttractionsUseCase
import com.nuriulgen.bitirmeodevi.domain.usecase.TopDestinationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val topDestinationUseCase: TopDestinationUseCase,
    private val nearbyAttractionsUseCase: NearbyAttractionsUseCase,
    private val allUseCase: AllUseCase
): ViewModel() {

    fun fetchDestination(): LiveData<List<TravelModel>> {
        topDestinationUseCase.apply {
            getTopDestination()
            return topDestination
        }
    }

    fun fetchNearbyAttractions(): LiveData<List<TravelModel>> {
        nearbyAttractionsUseCase.apply {
            getNearbyAttractions()
            return nearbyAttractions
        }
    }

    fun fetchAll(): LiveData<List<TravelModel>>{
        allUseCase.apply {
            getAll()
            return all
        }
    }
}