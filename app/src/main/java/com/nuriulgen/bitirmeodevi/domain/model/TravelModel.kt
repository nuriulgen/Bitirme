package com.nuriulgen.bitirmeodevi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Model'deki sayfalar arası veri taşınabilmesi için Parcelable kullanıldı.
 */
@Parcelize
data class TravelModel(
    val category: String? = null,
    val city: String? = null,
    val country: String? = null,
    val description: String? = null,
    val id: String? = null,
    val images: List<Image>? = null,
    val isBookmark: Boolean? = null,
    val title: String? = null
): Parcelable