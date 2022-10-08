package com.nuriulgen.bitirmeodevi.domain.repository

import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import retrofit2.Call

interface AllRepository {
    fun fetchAll(): Call<List<TravelModel>>
}