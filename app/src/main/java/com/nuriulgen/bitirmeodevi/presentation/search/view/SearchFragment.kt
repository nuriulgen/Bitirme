package com.nuriulgen.bitirmeodevi.presentation.search.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.adapter.NearbyAttractionsAdapter
import com.nuriulgen.bitirmeodevi.adapter.TopDestinationAdapter
import com.nuriulgen.bitirmeodevi.databinding.FragmentSearchBinding
import com.nuriulgen.bitirmeodevi.domain.model.TravelModel
import com.nuriulgen.bitirmeodevi.presentation.search.viewmodel.SearchViewModel
import com.nuriulgen.bitirmeodevi.util.ToastUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("InflateParams", "MissingInflatedId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.apply {

            /**
             * searchViewModel içerisinde birden fazla metod çağrılacağı için,
             * bu metodları apply() metodunun scope içerisinde toplanıldı.
             */
            fetchDestination().observe(viewLifecycleOwner) {
                binding.topDestinationRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                binding.topDestinationRecycler.adapter = TopDestinationAdapter(it)
            }

            fetchNearbyAttractions().observe(viewLifecycleOwner){
                binding.nearbyAttractionsRecycler.layoutManager = LinearLayoutManager(context)
                binding.nearbyAttractionsRecycler.adapter = NearbyAttractionsAdapter(it)
            }
        }


        binding.textField.setEndIconOnClickListener {
            /**
             * TextField içerisine yazılan value alınıp değişkene atıldı.
             */
            val searchText = binding.textInput.text.toString()

            searchViewModel.fetchAll().observe(viewLifecycleOwner){
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
                val action = SearchFragmentDirections.actionSearchFragmentToHomeDetailFragment(model)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }
}