package com.example.tt_hotelsearch.domain.model

import com.example.tt_hotelsearch.domain.adapter.ListItem

data class BookingFinalPriceModel(
    val tour: String,
    val fuelFees: String,
    val serviceFees: String,
    val totalPrice: String
): ListItem
