package com.nuriulgen.bitirmeodevi.presentation.trip.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.core.app.ActivityScenario.launch
import com.nuriulgen.bitirmeodevi.R
import com.nuriulgen.bitirmeodevi.adapter.AddItemAdapter
import com.nuriulgen.bitirmeodevi.data.local.TripDatabase

import com.nuriulgen.bitirmeodevi.databinding.FragmentTripBinding
import com.nuriulgen.bitirmeodevi.domain.model.AddItemModel
import com.nuriulgen.bitirmeodevi.util.ToastUtils
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TripFragment : Fragment() {

    private lateinit var binding : FragmentTripBinding
    private lateinit var addItemAdapter: AddItemAdapter
    private lateinit var itemList: ArrayList<AddItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTripBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList = ArrayList()
        lateinit var triplist: List<AddItemModel>

        runBlocking {
            /**
             * Room database kaydedilen değerleri liste atama işlemi yapılırken,
             * main (ui) thread kilitlenmemesi için coroutine kullanıldı.
             */
            triplist = TripDatabase(requireContext()).tripDao().getAllTrip()
        }

        /**
         * Room database eklenmiş value üzerinde gezip AddItenModel kısmına eklenme işlemi yapıldı.
         */
        for (itemModel in triplist) {
            itemList.add(AddItemModel(itemModel.title, itemModel.subTitle, itemModel.days))
        }

        /**
         * Oluşturulan adapter ve recycler view bağlanıldı.
         */
        addItemAdapter= context?.let { AddItemAdapter(it,itemList) }!!
        binding.itemRecyclerRow.layoutManager = LinearLayoutManager(context)
        binding.itemRecyclerRow.adapter = addItemAdapter

        binding.fab.setOnClickListener {
            addNewItem()
        }

    }

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    private fun addNewItem() {
        /**
         * Kullanılacak id'leri değişkenlerle eşletirme yapıldı.
         */
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.add_item,null)
        /**set view*/
        val city = v.findViewById<EditText>(R.id.editTitle)
        val country = v.findViewById<EditText>(R.id.editSubTitle)
        val day = v.findViewById<EditText>(R.id.daysText)

        val addDialog = AlertDialog.Builder(context)

        /**
         * Alert Dialog oluşturuldu.
         */
        addDialog.setView(v)
        addDialog.setPositiveButton("Save"){
                dialog,_->

            /**
             * EditText alanına girilen value değişkenlere atandı.
             */
            val citys = city.text.toString()
            val countrys = country.text.toString()
            val days = day.text.toString()

            /**
             * EditText gelen değerleri modele eklenip değişkene atandıç
             */
            val item = AddItemModel(citys, countrys, "$days day")
            itemList.add(item)
            runBlocking {
                /**
                 * Room database veri ekleme işlemi yapılırken UI bir kilitlenme
                 * olmaması adına CorutineScope içerisinde bu işlem yapıldı.
                 */
                TripDatabase(requireContext()).tripDao().insert(item)
            }
            /**
             * notifyDataSetChanged() metodu  değişen verileri dinler ve otomatik kendisi verleri update eder.
             */
            addItemAdapter.notifyDataSetChanged()
            Toast.makeText(context , "Successfully Added", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
            ToastUtils.showError("Cancel",context)
        }
        addDialog.create()
        addDialog.show()
    }
}

