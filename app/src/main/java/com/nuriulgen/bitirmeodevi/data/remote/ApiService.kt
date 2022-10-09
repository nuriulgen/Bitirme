package com.nuriulgen.bitirmeodevi.data.remote

import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    fun fetchAll(): Call<List<TravelModel>>

    @GET("?category=topdestination")
    fun fetchTopDestination(): Call<List<TravelModel>>

    @GET("?category=nearby")
    fun fetchNearbyAttractions(): Call<List<TravelModel>>

    @GET("?category=mightneed")
    fun fetchMightNeed(): Call<List<TravelModel>>

    @GET("?category=toppick")
    fun fetchTopPick(): Call<List<TravelModel>>
}

