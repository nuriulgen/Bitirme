package com.nuriulgen.bitirmeodevi.domain.model.mightNeed

data class MightNeedModel(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<İmage>,
    val isBookmark: Boolean,
    val title: String
)