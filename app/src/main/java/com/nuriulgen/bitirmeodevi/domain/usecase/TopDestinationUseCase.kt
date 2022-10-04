package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.TopDestinationModel
import com.nuriulgen.bitirmeodevi.domain.repository.TopDestinationRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class TopDestinationUseCase @Inject constructor(
    private val topDestinationRepository: TopDestinationRepository
) {

    private var _topDestination = MutableLiveData<List<TopDestinationModel>>()
    val topDestination: LiveData<List<TopDestinationModel>> = _topDestination



    fun getTopDestination(){
        topDestinationRepository.fetchTopDestination().enqueue(object:
            Callback<List<TopDestinationModel>> {
            override fun onResponse(
                call: Call<List<TopDestinationModel>>,
                response: Response<List<TopDestinationModel>>
            ) {
                println("onResponse çalıştı")
                println(response.body())
                _topDestination.value = response.body()
            }

            override fun onFailure(call: Call<List<TopDestinationModel>>, t: Throwable) {
               println("Hata $t")
            }

        })
    }
}


