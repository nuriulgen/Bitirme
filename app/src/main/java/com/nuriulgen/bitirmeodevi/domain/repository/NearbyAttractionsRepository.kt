package com.nuriulgen.bitirmeodevi.domain.repository

import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import retrofit2.Call

interface NearbyAttractionsRepository {
    fun fetchNearbyAttractions(): Call<List<TravelModel>>
}