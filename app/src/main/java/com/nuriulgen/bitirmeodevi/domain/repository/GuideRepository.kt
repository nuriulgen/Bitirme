package com.nuriulgen.bitirmeodevi.domain.repository

import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import retrofit2.Call

interface GuideRepository {
    fun fetchGuide(): Call<List<GuideModel>>
}