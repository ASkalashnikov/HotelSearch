package com.example.tt_hotelsearch.domain.management

import android.annotation.SuppressLint
import com.example.tt_hotelsearch.databinding.ItemBookingInformationBuyerBinding
import com.example.tt_hotelsearch.databinding.ItemBookingInformationTouristBinding

object AppContext {

    @SuppressLint("StaticFieldLeak")
    lateinit var itemBookingInformationBuyerBinding: ItemBookingInformationBuyerBinding

    @SuppressLint("StaticFieldLeak")
    lateinit var itemBookingInformationTouristBinding: ItemBookingInformationTouristBinding

    var numberPosition = 0
}