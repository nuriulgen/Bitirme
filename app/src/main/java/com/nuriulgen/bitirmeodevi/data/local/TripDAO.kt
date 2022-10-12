package com.nuriulgen.bitirmeodevi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nuriulgen.bitirmeodevi.domain.model.AddItemModel

@Dao
interface TripDAO {

    @Insert // Ekleme
    suspend fun insert(model : AddItemModel)

    // Insert -> sqlite insert into işlemi (ekleme).
    // Vararg -> birden fazla, istediğimiz kadar model obje ekleyebiliyoruz.

    @Query("SELECT * FROM trip") // Tüm Verileri Çekme.
    suspend fun getAllTrip() : List<AddItemModel>
}