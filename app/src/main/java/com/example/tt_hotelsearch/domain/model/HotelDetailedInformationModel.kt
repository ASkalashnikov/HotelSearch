package com.example.tt_hotelsearch.domain.model

import com.example.tt_hotelsearch.domain.adapter.ListItem

data class HotelDetailedInformationModel(
    val textOne: String,
    val textTwo: String,
    val textThree: String,
    val textFour: String,
    val textDescription: String
): ListItem
