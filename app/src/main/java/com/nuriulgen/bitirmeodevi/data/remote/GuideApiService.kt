package com.nuriulgen.bitirmeodevi.data.remote

import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import retrofit2.Call
import retrofit2.http.GET

interface GuideApiService {
    /**
     * GET istekleri için interface oluşturuldu.
     */

    @GET(".")
    fun fetchGuide(): Call<List<GuideModel>>

}

