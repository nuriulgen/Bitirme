package com.nuriulgen.bitirmeodevi.domain.model.topDestination

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopDestinationModel(
    val category: String? = null,
    val city: String? = null,
    val country: String? = null,
    val description: String? = null,
    val id: String? = null,
    val images: List<Image>? = null,
    val isBookmark: Boolean? = null,
    val title: String? = null
): Parcelable