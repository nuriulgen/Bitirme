package com.nuriulgen.bitirmeodevi.presentation.guide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.usecase.MightNeedUseCase
import com.nuriulgen.bitirmeodevi.domain.usecase.TopPickUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val mightNeedUseCase: MightNeedUseCase,
    private val topPickUseCase: TopPickUseCase
): ViewModel() {

    fun fetchMightNeed(): LiveData<List<TravelModel>> {
        mightNeedUseCase.apply {
            getMightNeed()
            return mightNeed
        }
    }

    fun fetchTopPick(): LiveData<List<TravelModel>> {
        topPickUseCase.apply {
            getTopPick()
            return topPick
        }
    }

}