package com.nuriulgen.bitirmeodevi.data.remote.repository

import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.AllRepository
import com.nuriulgen.bitirmeodevi.domain.repository.MightNeedRepository
import retrofit2.Call

class AllRepositoryImp(private val apiService: ApiService): AllRepository {

    /**
     * Oluşturulan ilgili repository implement edildi.
     */
    override fun fetchAll(): Call<List<TravelModel>> {
        return apiService.fetchAll()
    }
}