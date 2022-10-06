package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.mightNeed.MightNeedModel
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
    private var _mightNeed = MutableLiveData<List<MightNeedModel>>()
    val mightNeed: LiveData<List<MightNeedModel>> = _mightNeed

    fun getMightNeed(){
        mightNeedRepository.fetchMightNeed().enqueue(object: Callback<List<MightNeedModel>>{
            override fun onResponse(
                call: Call<List<MightNeedModel>>,
                response: Response<List<MightNeedModel>>
            ) {
                _mightNeed.value = response.body()
            }

            override fun onFailure(call: Call<List<MightNeedModel>>, t: Throwable) {
                Log.e("Might Need Error", t.toString())
            }

        })
    }
}