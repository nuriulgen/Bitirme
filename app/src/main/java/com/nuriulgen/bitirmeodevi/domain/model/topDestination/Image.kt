package com.nuriulgen.bitirmeodevi.domain.model.topDestination


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Image(
    val altText: @RawValue Any? = null,
    val height: Int? = null,
    val url: String? = null,
    val width: Int? = null
): Parcelable