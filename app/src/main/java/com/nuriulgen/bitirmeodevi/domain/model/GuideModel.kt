package com.nuriulgen.bitirmeodevi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Model'deki sayfalar arası veri taşınabilmesi için Parcelable kullanıldı.
 */
@Parcelize
data class GuideModel(
    val icon: String,
    val id: String,
    val title: String
): Parcelable