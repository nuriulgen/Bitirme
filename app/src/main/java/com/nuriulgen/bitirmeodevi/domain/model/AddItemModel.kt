package com.nuriulgen.bitirmeodevi.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip")
data class AddItemModel(
    /**
     * Oluşturulan her yeni item'in farklı bir  id alabilmesi için  @PrimaryKey(autoGenerate = true) kullanıldı.
     */
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val subTitle: String,
    val days: String
)
{
    constructor(title: String, subTitle: String, days: String): this(0, title, subTitle, days)
}
