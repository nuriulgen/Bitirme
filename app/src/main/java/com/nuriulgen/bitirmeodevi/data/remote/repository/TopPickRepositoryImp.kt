package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.TopPickRepository
import retrofit2.Call

class TopPickRepositoryImp(private val apiService: ApiService): TopPickRepository {
    override fun fetchTopPick(): Call<List<TravelModel>> {
       return apiService.fetchTopPick()
    }
}