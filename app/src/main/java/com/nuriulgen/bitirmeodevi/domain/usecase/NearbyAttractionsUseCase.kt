package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.nearbyAttractions.NearbyAttractionsModel
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
    private var _nearbyAttractions = MutableLiveData<List<NearbyAttractionsModel>>()
    val nearbyAttractions : LiveData<List<NearbyAttractionsModel>> = _nearbyAttractions

    fun getNearbyAttractions(){
        nearbyAttractionsRepository.fetchNearbyAttractions().enqueue(object: Callback<List<NearbyAttractionsModel>>{
            override fun onResponse(
                call: Call<List<NearbyAttractionsModel>>,
                response: Response<List<NearbyAttractionsModel>>
            ) {
                _nearbyAttractions.value = response.body()
            }

            override fun onFailure(call: Call<List<NearbyAttractionsModel>>, t: Throwable) {
                Log.e("Nearby Attractions Error", t.toString())
            }

        } )
    }
}