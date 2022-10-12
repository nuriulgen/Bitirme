package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.domain.repository.AllRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AllUseCase @Inject constructor(
    private val allRepository: AllRepository
) {
    /**
     * Encapsulation
     */
    private var _all = MutableLiveData<List<TravelModel>>()
    val all: LiveData<List<TravelModel>> = _all

    /**
     * API get request işlemi yapıldı.
     * Bu get request başarılı veya başarsız olması durumlarına karşın uygun senaryolar yazıldı.
     */
    fun getAll(){
        allRepository.fetchAll().enqueue(object:
            retrofit2.Callback<List<TravelModel>>{
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _all.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                Log.e("All Error", t.toString())
            }

        })
    }
}