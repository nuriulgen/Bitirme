package com.nuriulgen.bitirmeodevi.data.remote

import com.nuriulgen.bitirmeodevi.domain.model.TopDestinationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?category=topdestination")
    fun fetchTopDestination() : Call<List<TopDestinationModel>>
}