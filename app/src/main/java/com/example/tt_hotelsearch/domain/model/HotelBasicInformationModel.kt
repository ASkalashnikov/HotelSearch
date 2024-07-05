package com.example.tt_hotelsearch.domain.model

import com.denzcoskun.imageslider.models.SlideModel
import com.example.tt_hotelsearch.domain.adapter.ListItem

data class HotelBasicInformationModel(
    val image: List<SlideModel>,
    val rating: String,
    val title: String,
    val address: String,
    val price: String
): ListItem
