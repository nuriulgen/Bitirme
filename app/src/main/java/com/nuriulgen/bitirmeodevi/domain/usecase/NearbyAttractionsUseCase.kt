package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.NearbyAttractionsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NearbyAttractionsUseCase @Inject constructor(
    private val nearbyAttractionsRepository: NearbyAttractionsRepository
) {
    /**
     * Encapsulation
     */
    private var _nearbyAttractions = MutableLiveData<List<TravelModel>>()
    val nearbyAttractions : LiveData<List<TravelModel>> = _nearbyAttractions

    /**
     * API get request işlemi yapıldı.
     * Bu get request başarılı veya başarsız olması durumlarına karşın uygun senaryolar yazıldı.
     */
    fun getNearbyAttractions(){
        nearbyAttractionsRepository.fetchNearbyAttractions().enqueue(object: Callback<List<TravelModel>>{
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _nearbyAttractions.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                Log.e("Nearby Attractions Error", t.toString())
            }

        } )
    }
}