package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.MightNeedRepository
import retrofit2.Call

class MightNeedRepositoryImp(private val apiService: ApiService): MightNeedRepository {

    override fun fetchMightNeed(): Call<List<TravelModel>> {
        return apiService.fetchMightNeed()
    }
}