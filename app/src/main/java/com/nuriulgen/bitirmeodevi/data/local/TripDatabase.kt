package com.nuriulgen.bitirmeodevi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nuriulgen.bitirmeodevi.domain.model.AddItemModel

@Database(entities = [AddItemModel::class], version = 2)
abstract class TripDatabase : RoomDatabase() {

    abstract fun tripDao() : TripDAO

    /**
     *Singleton
     */

    companion object {
        /**
         * Volatile -> instance değişkenini diğer thread'lere görünür yapar
         */

        @Volatile private var instance : TripDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context:Context) = Room.databaseBuilder(
            context.applicationContext,
            TripDatabase::class.java, "tripDatabase")
            .build()
    }

}
