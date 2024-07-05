package com.example.tt_hotelsearch.domain.model

import com.example.tt_hotelsearch.domain.adapter.ListItem

data class BookingHotelModel(
    val rating: String,
    val title: String,
    val address: String
): ListItem
