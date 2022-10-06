package com.nuriulgen.bitirmeodevi.data.remote

import com.nuriulgen.bitirmeodevi.domain.model.mightNeed.MightNeedModel
import com.nuriulgen.bitirmeodevi.domain.model.nearbyAttractions.NearbyAttractionsModel
import com.nuriulgen.bitirmeodevi.domain.model.topDestination.TopDestinationModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("?category=topdestination")
    fun fetchTopDestination(): Call<List<TopDestinationModel>>

    @GET("?category=nearby")
    fun fetchNearbyAttractions(): Call<List<NearbyAttractionsModel>>

    @GET("?category=mightneed")
    fun fetchMightNeed(): Call<List<MightNeedModel>>
}