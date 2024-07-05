package com.example.tt_hotelsearch.domain.model

import com.example.tt_hotelsearch.domain.adapter.ListItem

data class BookingInformationBuyerModel(
    val title: String,
    val description: String
): ListItem
