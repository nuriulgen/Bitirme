package com.nuriulgen.bitirmeodevi.presentation.guide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.usecase.AllUseCase
import com.nuriulgen.bitirmeodevi.domain.usecase.GuideUseCase
import com.nuriulgen.bitirmeodevi.domain.usecase.MightNeedUseCase
import com.nuriulgen.bitirmeodevi.domain.usecase.TopPickUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val mightNeedUseCase: MightNeedUseCase,
    private val topPickUseCase: TopPickUseCase,
    private val guideUseCase: GuideUseCase,
    private val allUseCase: AllUseCase
): ViewModel() {

    /**
     * Sayfada kullanılacak get request, view kısmından ayırıp viewModel içerisinde çağırıldı
     */

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

    fun fetchAll(): LiveData<List<TravelModel>>{
        allUseCase.apply {
            getAll()
            return all
        }
    }

    fun fetchGuide(): LiveData<List<GuideModel>>{
        guideUseCase.apply {
            getGuide()
            return guide
        }
    }
}