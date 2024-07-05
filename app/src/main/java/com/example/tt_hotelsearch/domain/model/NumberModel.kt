package com.example.tt_hotelsearch.domain.model

import com.denzcoskun.imageslider.models.SlideModel
import com.example.tt_hotelsearch.domain.adapter.ListItem

data class NumberModel(
    val image: List<SlideModel>,
    val title: String,
    val textOne: String,
    val textTwo: String,
    val price: String
): ListItem
