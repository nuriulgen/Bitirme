package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.topDestination.TopDestinationModel
import com.nuriulgen.bitirmeodevi.domain.repository.TopDestinationRepository
import retrofit2.Call

class TopDestinationRepositoryImp(private val apiService: ApiService) : TopDestinationRepository {

    override fun fetchTopDestination(): Call<List<TopDestinationModel>> {
        return apiService.fetchTopDestination()
    }
}