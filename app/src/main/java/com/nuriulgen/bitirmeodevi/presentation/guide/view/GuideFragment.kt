package com.nuriulgen.bitirmeodevi.presentation.guide.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.adapter.ChipsAdapter
import com.nuriulgen.bitirmeodevi.adapter.MightNeedAdapter
import com.nuriulgen.bitirmeodevi.adapter.TopPickAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentGuideBinding
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel

import com.nuriulgen.bitirmeodevi.presentation.guide.viewmodel.GuideViewModel
import com.nuriulgen.bitirmeodevi.presentation.search.view.SearchFragmentDirections
import com.nuriulgen.bitirmeodevi.util.ToastUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private val guideViewModel by viewModels<GuideViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuideBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * guideViewModel içerisinde birden fazla metod çağrılacağı için,
         * bu metodları apply() metodunun scope içerisinde toplanıldı.
         */
        guideViewModel.apply {

            fetchMightNeed().observe(viewLifecycleOwner){
                binding.mightNeedRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                binding.mightNeedRecycler.adapter = MightNeedAdapter(it)
            }

            fetchTopPick().observe(viewLifecycleOwner){
                binding.topPickRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                binding.topPickRecycler.adapter = TopPickAdapter(it)
            }

            fetchGuide().observe(viewLifecycleOwner){
                binding.chipsRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                binding.chipsRecycler.adapter = ChipsAdapter(it)
            }
        }

        searchCity()
}

    private fun searchCity(){
        binding.guideTextField.setEndIconOnClickListener {
            /**
             * TextField içerisine yazılan value alınıp değişkene atıldı.
             */
            val searchText = binding.guideTextInput.text.toString()

            guideViewModel.fetchAll().observe(viewLifecycleOwner){
                var model = TravelModel()
                for (travelModel in it)
                {
                    /**
                     * Model'in içerisinde bulunan ve aranılan değeleri,
                     * büyük, küçük harf sorunu olmaması için lowercase() metodu kullanıldı.
                     */
                    if (travelModel.city!!.lowercase() == searchText.lowercase()) {
                        model = travelModel
                        break
                    }
                }

                /**
                 * Eğer aranılan değer Api'den gelen değerle eşleşmemesi durumunda,
                 * kullanıciya toast message gösterildi.
                 */
                if(model.city.isNullOrEmpty()){
                    ToastUtils.showError("No Results",context)
                }

                /**
                 * Aranılan value değeri API'da mevcut ise bu value değeri ile ilgli detail sayfasına yönlendirild.
                 */
                val action = GuideFragmentDirections.actionGuideFragmentToHomeDetailFragment(model)
                view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
            }
        }
    }
}