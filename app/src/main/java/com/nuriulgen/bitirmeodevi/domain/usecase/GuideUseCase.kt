package com.nuriulgen.bitirmeodevi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuriulgen.bitirmeodevi.domain.model.GuideModel
import com.nuriulgen.bitirmeodevi.domain.repository.GuideRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GuideUseCase @Inject constructor(private val guideRepository: GuideRepository) {

    /**
     * Encapsulation
     */
    private var _guide = MutableLiveData<List<GuideModel>>()
    val guide: LiveData<List<GuideModel>> = _guide

    fun getGuide(){
        guideRepository.fetchGuide().enqueue(object:
            Callback<List<GuideModel>>{
            override fun onResponse(
                call: Call<List<GuideModel>>,
                response: Response<List<GuideModel>>
            ) {
                _guide.value = response.body()
                println(response.body())
            }

            override fun onFailure(call: Call<List<GuideModel>>, t: Throwable) {
                Log.e("Guide Error", t.toString())
            }

        })
    }
}