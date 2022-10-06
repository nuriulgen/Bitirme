package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.mightNeed.MightNeedModel
import com.nuriulgen.bitirmeodevi.domain.repository.MightNeedRepository
import retrofit2.Call

class MightNeedRepositoryImp(private val apiService: ApiService): MightNeedRepository {

    override fun fetchMightNeed(): Call<List<MightNeedModel>> {
        return apiService.fetchMightNeed()
    }
}