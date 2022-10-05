package com.nuriulgen.bitirmeodevi.domain.model.nearbyAttractions

data class NearbyAttractionsModel(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<İmage>,
    val isBookmark: Boolean,
    val title: String
)