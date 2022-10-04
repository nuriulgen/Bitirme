package com.nuriulgen.bitirmeodevi.domain.model

data class TopDestinationModel(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<Image>,
    val isBookmark: Boolean,
    val title: String
)