package com.example.tt_hotelsearch.domain.model

import com.example.tt_hotelsearch.domain.adapter.ListItem

data class BookingDataModel(
    val city: String,
    val country: String,
    val calendar: String,
    val numberNights: String,
    val hotel: String,
    val number: String,
    val nutrition: String
): ListItem