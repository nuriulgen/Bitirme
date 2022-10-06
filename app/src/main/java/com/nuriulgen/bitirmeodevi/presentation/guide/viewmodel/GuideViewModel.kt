package com.nuriulgen.bitirmeodevi.presentation.guide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuriulgen.bitirmeodevi.domain.model.mightNeed.MightNeedModel
import com.nuriulgen.bitirmeodevi.domain.usecase.MightNeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val mightNeedUseCase: MightNeedUseCase
): ViewModel() {

    fun fetchMightNeed(): LiveData<List<MightNeedModel>> {
        mightNeedUseCase.apply {
            getMightNeed()
            return mightNeed
        }
    }

}