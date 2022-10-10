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

        itemList = ArrayList()
        lateinit var triplist: List<AddItemModel>

        runBlocking {
            triplist = TripDatabase(requireContext()).tripDao().getAllTrip()
        }

        for (itemModel in triplist) {
            itemList.add(AddItemModel(itemModel.title, itemModel.subTitle, itemModel.days))
        }

        super.onViewCreated(view, savedInstanceState)
        addItemAdapter= context?.let { AddItemAdapter(it,itemList) }!!
        binding.itemRecyclerRow.layoutManager = LinearLayoutManager(context)
        binding.itemRecyclerRow.adapter = addItemAdapter

        binding.fab.setOnClickListener {
            addNewItem()
        }


    }
    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    private fun addNewItem() {
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.add_item,null)
        /**set view*/
        val city = v.findViewById<EditText>(R.id.editTitle)
        val country = v.findViewById<EditText>(R.id.editSubTitle)
        val day = v.findViewById<EditText>(R.id.daysText)

        val addDialog = AlertDialog.Builder(context)

        addDialog.setView(v)
        addDialog.setPositiveButton("Save"){
                dialog,_->
            val citys = city.text.toString()
            val countrys = country.text.toString()
            val days = day.text.toString()

            val item = AddItemModel(citys, countrys, "$days day")
            itemList.add(item)
            runBlocking {
                TripDatabase(requireContext()).tripDao().insert(item)
            }
            addItemAdapter.notifyDataSetChanged()
            Toast.makeText(context , "Adding new item", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
            Toast.makeText(context , "Cancel", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }
}

