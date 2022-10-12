package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.NearbyAttractionsRepository
import retrofit2.Call

class NearbyAttractionsRepositoryImp(private val apiService: ApiService): NearbyAttractionsRepository {

    /**
     * Oluşturulan ilgili repository implement edildi.
     */
    override fun fetchNearbyAttractions(): Call<List<TravelModel>> {
        return apiService.fetchNearbyAttractions()
    }
}