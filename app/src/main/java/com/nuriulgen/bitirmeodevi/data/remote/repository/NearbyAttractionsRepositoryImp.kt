package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.nearbyAttractions.NearbyAttractionsModel
import com.nuriulgen.bitirmeodevi.domain.model.topDestination.TopDestinationModel
import com.nuriulgen.bitirmeodevi.domain.repository.NearbyAttractionsRepository
import retrofit2.Call

class NearbyAttractionsRepositoryImp(private val apiService: ApiService): NearbyAttractionsRepository {

    override fun fetchNearbyAttractions(): Call<List<NearbyAttractionsModel>> {
        return apiService.fetchNearbyAttractions()
    }
}