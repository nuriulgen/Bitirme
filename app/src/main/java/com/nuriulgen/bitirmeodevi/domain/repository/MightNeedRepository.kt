package com.nuriulgen.bitirmeodevi.domain.repository

import com.nuriulgen.bitirmeodevi.domain.model.mightNeed.MightNeedModel
import retrofit2.Call

interface MightNeedRepository {
    fun fetchMightNeed(): Call<List<MightNeedModel>>
}