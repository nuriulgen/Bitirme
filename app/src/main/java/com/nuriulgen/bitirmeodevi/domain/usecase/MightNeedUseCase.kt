package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.MightNeedRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MightNeedUseCase @Inject constructor(
    private val mightNeedRepository: MightNeedRepository
) {
    /**
     * Encapsulation
     */
    private var _mightNeed = MutableLiveData<List<TravelModel>>()
    val mightNeed: LiveData<List<TravelModel>> = _mightNeed

    /**
     * API get request işlemi yapıldı.
     * Bu get request başarılı veya başarsız olması durumlarına karşın uygun senaryolar yazıldı.
     */
    fun getMightNeed(){
        mightNeedRepository.fetchMightNeed().enqueue(object: Callback<List<TravelModel>>{
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _mightNeed.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                Log.e("Might Need Error", t.toString())
            }
        })
    }
}