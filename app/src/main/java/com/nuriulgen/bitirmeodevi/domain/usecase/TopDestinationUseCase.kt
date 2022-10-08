package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.TopDestinationRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class TopDestinationUseCase @Inject constructor(
    private val topDestinationRepository: TopDestinationRepository
) {
    /**
     * Encapsulation
     */
    private var _topDestination = MutableLiveData<List<TravelModel>>()
    val topDestination: LiveData<List<TravelModel>> = _topDestination

    fun getTopDestination(){
        topDestinationRepository.fetchTopDestination().enqueue(object: Callback<List<TravelModel>> {
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _topDestination.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
               Log.e("Top Destination Error", t.toString())
            }

        })
    }
}


