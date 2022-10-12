package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.TopDestinationRepository
import retrofit2.Call

class TopDestinationRepositoryImp(private val apiService: ApiService) : TopDestinationRepository {

    /**
     * Oluşturulan ilgili repository implement edildi.
     */
    override fun fetchTopDestination(): Call<List<TravelModel>> {
        return apiService.fetchTopDestination()
    }
}