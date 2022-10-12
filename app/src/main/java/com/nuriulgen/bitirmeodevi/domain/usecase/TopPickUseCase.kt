package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.TopPickRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class TopPickUseCase @Inject constructor(
    private val topPickRepository: TopPickRepository
) {
    /**
     * Encapsulation
     */

    private var _topPick = MutableLiveData<List<TravelModel>>()
    val topPick: LiveData<List<TravelModel>> = _topPick

    /**
     * API get request işlemi yapıldı.
     * Bu get request başarılı veya başarsız olması durumlarına karşın uygun senaryolar yazıldı.
     */
    fun getTopPick(){
        topPickRepository.fetchTopPick().enqueue(object: retrofit2.Callback<List<TravelModel>> {
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _topPick.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                Log.e("Top Pick Error", t.toString())
            }
        })
    }
}