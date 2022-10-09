package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.data.remote.GuideApiService
import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.repository.GuideRepository
import retrofit2.Call

class GuideRepositoryImp(private val guideApiService: GuideApiService): GuideRepository {

    override fun fetchGuide(): Call<List<GuideModel>> {
        return guideApiService.fetchGuide()
    }
}