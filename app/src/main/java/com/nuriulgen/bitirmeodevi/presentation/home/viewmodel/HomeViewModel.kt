package com.nuriulgen.bitirmeodevi.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.usecase.AllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val allUseCase: AllUseCase): ViewModel() {

    fun fetchAll(): LiveData<List<TravelModel>> {
        allUseCase.apply {
            getAll()
            return all
        }
    }

}